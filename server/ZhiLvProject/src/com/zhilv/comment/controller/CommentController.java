package com.zhilv.comment.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhilv.comment.service.CommentService;
import com.zhilv.entity.Comment;
import com.zhilv.entity.Travels;
import com.zhilv.entity.User;
import com.zhilv.entity.Video;
import com.zhilv.mailmycomment.service.MailMyCommentService;
import com.zhilv.replycomment.service.ReplyCommentService;
import com.zhilv.travels.service.TravelsService;
import com.zhilv.util.DateUtil;
import com.zhilv.video.service.VideoService;

/**   
 * @ClassName: CommentController   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��27�� ����10:31:17       
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Resource
	private CommentService commentService;
	@Resource
	private ReplyCommentService replyCommentService;
	@Resource
	private TravelsService travelsService;
	@Resource
	private VideoService videoService;
	@Resource
	private MailMyCommentService mailMyCommentService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String list(@RequestParam(value="travelsId",required=false)Integer travelsId,
			@RequestParam(value="videoId",required=false)Integer videoId) {
		List<Comment> list= commentService.findCommentByNoteId(travelsId, videoId);
		for(int i = 0; i < list.size(); ++i) {
			list.get(i).setReplyCount(replyCommentService.queryCountOfReplyByCommentId(list.get(i).getId()));
		}
		if(list.size() > 0) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			String str = gson.toJson(list);
			System.out.println("����" + list.size() + "������");
			return str;
		}else {
			System.out.println("����0������");
			return null;
		}
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public String add(@RequestParam(value="videoId",required=false)Integer videoId,
		@RequestParam(value="travelsId",required=false)Integer travelsId,
		@RequestParam(value="userId",required=true)Integer userId,
		@RequestParam(value="commentContent",required=true)String commentContent) {
		Travels travels = new Travels();
		travels.setTravelsId(travelsId);
		Video video = new Video();
		video.setVideoId(videoId);
		User user = new User();
		user.setUserId(userId);
		Comment comment = new Comment();
		comment.setContent(commentContent);
		comment.setTravels(travels);
		comment.setVideo(video);
		comment.setUser(user);
		comment.setTime(DateUtil.getCurrentTimes());
		int i = commentService.addComment(comment);
		String str = "OK";
		if(i > 0) {
			System.out.println("������ӳɹ�");
			if(null != travelsId) { //������μ�
				travels = travelsService.findTravelsById(travelsId);//�μ���ϸ��Ϣ
				if(travels.getUser().getUserId() != userId) { //������Ǳ��˷���������
					int j = mailMyCommentService.addMailMyCommentService(travels.getUser().getUserId(), comment.getId(), null, 'C');
					if(j > 0) {
						System.out.println("�μ�֪ͨ��Ϣд��ɹ�");
					}else {
						System.out.println("�μ�֪ͨ��Ϣд��ʧ��");
					}
				}
			}else {
				video = videoService.findVideoById(videoId);
				if(video.getUser().getUserId() != userId) {
					int j = mailMyCommentService.addMailMyCommentService(video.getUser().getUserId(), comment.getId(), null, 'C');
					if(j > 0) {
						System.out.println("��Ƶ֪ͨ��Ϣд��ɹ�");
					}else {
						System.out.println("�μ�֪ͨ��Ϣд��ʧ��");
					}
				}
			}
		}else {
			str = "ERROR";
			System.out.println("�������ʧ��");
		}
		return str+","+comment.getId();
	}
}









