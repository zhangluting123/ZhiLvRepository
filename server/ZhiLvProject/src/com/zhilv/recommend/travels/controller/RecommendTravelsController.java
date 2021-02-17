/**
 * 
 */
package com.zhilv.recommend.travels.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.zhilv.entity.InterestLabel;
import com.zhilv.entity.Note;
import com.zhilv.entity.Travels;
import com.zhilv.entity.User;
import com.zhilv.entity.UserCollection;
import com.zhilv.entity.UserGood;
import com.zhilv.entity.Video;
import com.zhilv.note.service.NoteService;
import com.zhilv.recommend.travels.service.RecommendTravelsService;
//import com.zhilv.recommend.userInterestManagement.service.UserInterestManagementService;
import com.zhilv.travels.service.TravelsService;
import com.zhilv.user.service.UserService;
import com.zhilv.usercollection.service.CollectionService;
import com.zhilv.usergood.service.GoodService;
import com.zhilv.util.SortUtil;
import com.zhilv.video.service.VideoService;

import sun.tools.jar.resources.jar;

/**
 * @ClassName:RecommendTravelsController
 * @description:TODO
 * @author :������
 * @date:2021��2��8��
 */

@RestController
@RequestMapping("recommend/travels")
public class RecommendTravelsController {
	
	@Resource
	private RecommendTravelsService recommendTravelsService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private TravelsService travelsService;
	@Resource
	private NoteService noteService;
	@Resource
	private VideoService videoService;
	@Resource
	private GoodService goodService;
	@Resource
	private CollectionService collectionService;

	
	
	/**
	 * 
	 * @description:�û�Эͬ�����㷨����ȡ�Ƽ��б�
	 * @author :������
	 * @date:2021��2��10��
	 * @param userId
	 * @return
	 */
	//http://localhost:8080/ZhiLvProject/recommend/travels/getRecommendList?userId=1
	@RequestMapping(value = "/getRecommendList",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	public String getRecommendList(@RequestParam("userId")Integer userId) {
		List<User> similarityUsers = getSimilarUser(userId);
		List<Note> recommendList = new ArrayList<>();
		
		recommendList.addAll(getPublishList(similarityUsers));
		recommendList.addAll(getGoodList(similarityUsers));
		recommendList.addAll(getCollectionList(similarityUsers));
		recommendList = removeRepeat(recommendList);
		if(recommendList.size()>0) {
			Gson gson = new Gson();
			String str = gson.toJson(recommendList);
			return str;
		}else {
			return null;
		}	
	}

	
	/**
	 * 
	 * @description:��ȡ����û��������μ�
	 * @author :������
	 * @date:2021��2��9��
	 * @param users
	 * @return
	 */
	//http://localhost:8080/ZhiLvProject/recommend/travels/getPublishList
	@RequestMapping(value = "/getPublishList",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	public List<Note> getPublishList(List<User> users){
		List<Note> publishList=new ArrayList<>();
		for(int i=0;i<users.size();i++) {
			publishList.addAll(userList(users.get(i).getUserId()));
		}
		return publishList;
	}

	/**
	 * 
	 * @description:��ȡ����û������б�
	 * @author :������
	 * @date:2021��2��13��
	 * @param users
	 * @return
	 */
	//http://localhost:8080/ZhiLvProject/recommend/travels/getGoodList
	@RequestMapping(value = "/getGoodList",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	public List<Note> getGoodList(List<User> users){
		List<Note> userGoodList = new ArrayList<Note>();
		for(int i=0;i<users.size();i++) {
			userGoodList.addAll(goodList(users.get(i).getUserId()));
		}
		return userGoodList;
	}
	/**
	 * 
	 * @description:��ȡ����û��ղص��б�
	 * @author :������
	 * @date:2021��2��13��
	 * @param users
	 * @return
	 */
	//http://localhost:8080/ZhiLvProject/recommend/travels/getCollectionList
	@RequestMapping(value = "/getCollectionList",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	public List<Note> getCollectionList(List<User> users){
		List<Note> userCollectionList = new ArrayList<Note>();
		for(int i=0;i<users.size();i++) {
			userCollectionList.addAll(collectionList(users.get(i).getUserId()));
		}
		return userCollectionList;
	}
	
	/**
	 * 
	 * @description:��ȡ�͵�ǰ�û���ص��û�����
	 * @author :������
	 * @date:2021��2��9��
	 * @param userId
	 * @return
	 */
	//http://localhost:8080/ZhiLvProject/recommend/travels/getSimilarUser?userId=1
	@RequestMapping(value = "/getSimilarUser",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	public List<User> getSimilarUser(@RequestParam("userId")Integer userId){
		List<User> allUsers=userService.findAllUser();
		for(int i=0;i<allUsers.size();i++) {
			if(allUsers.get(i).getUserId()==userId) {
				allUsers.remove(i);
			}
		}
		List<User> similarUsers = new ArrayList<>();
		List<InterestLabel> userInterest1 = recommendTravelsService.findUserInterest(userId);
		for(int i = 0;i < allUsers.size(); i++)
		{
			List<InterestLabel> userInterest2=recommendTravelsService.findUserInterest(allUsers.get(i).getUserId());
			System.out.println(i);
			if(userSimilarity(userInterest1, userInterest2)>0.0) {
				similarUsers.add(allUsers.get(i));
				System.out.println(userSimilarity(userInterest1, userInterest2));
			}
		}
		
		return similarUsers;
	}
	
	/**
	 * 
	 * @description:����Jaccard��ʽ�����û���Ȥ���ƶ�
	 * @author :������
	 * @date:2021��2��9��
	 * @param userId1
	 * @param userId2
	 * @return �û���Ȥ���ƶȣ�intersection / union��
	 */
	
	//http://localhost:8080/ZhiLvProject/recommend/travels/userSimilarity?userId1=1&userId2=2
	@RequestMapping(value = "/userSimilarity",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	public double userSimilarity(List<InterestLabel> userInterest1,List<InterestLabel> userInterest2) {
		
		System.out.println(userInterest1);
		System.out.println(userInterest2);
		List<String> union = new ArrayList<>();
		List<String> intersection = new ArrayList<>();
		//��userInterest1�е�Ԫ���ȷ���union
		for(int i = 0;i<userInterest1.size();i++) {
			union.add(userInterest1.get(i).getLabelName());
		}
		//��userInterest2��union���бȽ�
		for(int i = 0;i < userInterest2.size(); i++) {
			if(union.contains(userInterest2.get(i).getLabelName())) {
				//��������д��ڣ����뵽������
				intersection.add(userInterest2.get(i).getLabelName());
			}else {
				//��������в����ڣ����뵽������
				union.add(userInterest2.get(i).getLabelName());
			}
		}
		System.out.println(intersection);
		System.out.println(union);
		
		// ������Ȥ���ƶ� intersection/union
		if(union.size()!=0) {
			double similarity = (double) intersection.size()/union.size();
			return similarity;
		}else {
			return 0.0;
		}
		
	}
	
	/**
	 * 
	 * @description:����userId��ȡ�û�������note
	 * @author :������
	 * @date:2021��2��11��
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/userlist",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public List<Note> userList(Integer userId) {
		List<Travels> list = travelsService.findTravelsByUserId(userId);
		List<Video> videoList = videoService.findVideoByUserId(userId);
		List<Note> noteList = new ArrayList<Note>();
		for(Travels travels: list) {
			Note note = new Note();
			note.setFlag(true);
			note.setTime(travels.getUploadTime());
			note.setTravels(travels);
			noteList.add(note);
		}
		for(Video video: videoList) {
			Note note = new Note();
			note.setFlag(false);
			note.setTime(video.getUploadTime());
			note.setVideo(video);
			noteList.add(note);
		}
		//����ʱ���note��������
		SortUtil.sortList(noteList, "time", "DESC");
		
		return noteList;
	}
	/**
	 * 
	 * @description:����userId��ȡ�û��ղص�note
	 * @author :������
	 * @date:2021��2��13��
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/collectionlist",method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public List<Note> collectionList(@RequestParam("userId")Integer userId) {
		List<UserCollection> list = collectionService.findAllCollection(userId);
		List<Note> noteList = new ArrayList<Note>();
		Note note = null;
		for(int i = 0; i < list.size(); ++i) {
			if(null != list.get(i).getTravels()) {
				note = new Note();
				note.setFlag(true);
				note.setTime(list.get(i).getTime());
				note.setTravels(list.get(i).getTravels());
				noteList.add(note);
			}else {
				note = new Note();
				note.setFlag(false);
				note.setTime(list.get(i).getTime());
				note.setVideo(list.get(i).getVideo());
				noteList.add(note);
			}
		}
		
		return noteList;
	}
	
	/**
	 * 
	 * @description:����userId��ȡ�û����޵�note
	 * @author :������
	 * @date:2021��2��13��
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/goodlist",method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public List<Note> goodList(@RequestParam("userId")Integer userId) {
		List<UserGood> list = goodService.findAllGood(userId);
		List<Note> noteList = new ArrayList<Note>();
		Note note = null;
		for(int i = 0; i < list.size(); ++i) {
			if(null != list.get(i).getTravels()) {
				note = new Note();
				note.setFlag(true);
				note.setTime(list.get(i).getTime());
				note.setTravels(list.get(i).getTravels());
				noteList.add(note);
			}else {
				note = new Note();
				note.setFlag(false);
				note.setTime(list.get(i).getTime());
				note.setVideo(list.get(i).getVideo());
				noteList.add(note);
			}
		}
		
		return noteList;
	}
	
	
	public List<Note> removeRepeat(List<Note> recommendList){
		List<Integer> travelsIdList = new ArrayList<Integer>();
		List<Integer> videoIdList = new ArrayList<Integer>();
		int j = -1;
		boolean flag;
		for(int i = 0; i < recommendList.size(); ++i) {
			flag = false;
			boolean b = recommendList.get(i).isFlag();
			if(b && travelsIdList.size() <= 0) {
				travelsIdList.add(recommendList.get(i).getTravels().getTravelsId());
			}else if(b && travelsIdList.size() > 0) {
				for(j = 0; j < travelsIdList.size(); ++j) {
					if(travelsIdList.get(j) == recommendList.get(i).getTravels().getTravelsId()) {
						recommendList.remove(i);
						i--;
						flag = true;
						break;
					}
				}
				if(j >= travelsIdList.size() && !flag) {
					travelsIdList.add(recommendList.get(i).getTravels().getTravelsId());
				}
			}else if(!b && recommendList.size() <= 0) {
				videoIdList.add(recommendList.get(i).getVideo().getVideoId());
			}else {
				for(j = 0; j < videoIdList.size(); ++j) {
					if(videoIdList.get(j) == recommendList.get(i).getVideo().getVideoId()) {
						recommendList.remove(i);
						i--;
						flag = true;
						break;
					}
				}
				if(j >= videoIdList.size() && !flag) {
					videoIdList.add(recommendList.get(i).getVideo().getVideoId());
				}
			}
			
		}
		return recommendList;
	}

}
