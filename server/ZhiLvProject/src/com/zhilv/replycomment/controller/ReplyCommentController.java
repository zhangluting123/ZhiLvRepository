package com.zhilv.replycomment.controller;

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
import com.zhilv.entity.ReplyComment;
import com.zhilv.entity.User;
import com.zhilv.mailmycomment.service.MailMyCommentService;
import com.zhilv.replycomment.service.ReplyCommentService;
import com.zhilv.travels.service.TravelsService;
import com.zhilv.util.DateUtil;
import com.zhilv.video.service.VideoService;

/**   
 * @ClassName: ReplyCommentController   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月27日 上午10:32:31       
 */
@RestController
@RequestMapping("/reply")
public class ReplyCommentController {
	
	@Resource
	private ReplyCommentService replyCommentService;
	@Resource
	private CommentService commentService;
	@Resource
	private VideoService videoService;
	@Resource
	private TravelsService travelsService;
	@Resource
	private MailMyCommentService mailMyCommentService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String list(@RequestParam(value="commentId",required=true)Integer commentId) {
		List<ReplyComment> replys = replyCommentService.queryReplyCommentByCommentId(commentId);
		if(replys.size() > 0) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			String str = gson.toJson(replys);
			return str;
		}else {
			return null;
		}
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String add(@RequestParam(value="replyContent",required=true)String replyContent,
			@RequestParam(value="replyUserId",required=true)Integer replyUserId,
			@RequestParam(value="commentId",required=true)Integer commentId) {
		Comment comment = new Comment();
		comment.setId(commentId);
		User user = new User();
		user.setUserId(replyUserId);
		ReplyComment replyComment = new ReplyComment();
		replyComment.setReplyContent(replyContent);
		replyComment.setReplyTime(DateUtil.getCurrentTimes());
		replyComment.setComment(comment);
		replyComment.setReplyUser(user);
		String str = "OK";
		int i = replyCommentService.insertReplyComment(replyComment);
		if(i > 0) {
			System.out.println("评论的回复添加成功");
			comment = commentService.findCommentById(commentId);
			if(comment.getUser().getUserId() != replyUserId) {
				int j = mailMyCommentService.addMailMyCommentService(comment.getUser().getUserId(), null, replyComment.getReplyId(), 'R');
				if(j > 0) {
					System.out.println("[评论的回复]通知添加成功");
				}else {
					System.out.println("[评论的回复]通知添加失败");
				}
			}
		}else {
			str = "ERROR";
			System.out.println("评论的回复添加失败");
		}
		return str;
	}
	
	@RequestMapping(value="/addReplyToReply",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String addReply(@RequestParam(value="replyContent",required=true)String replyContent,
			@RequestParam(value="replyUserId",required=true)Integer replyUserId,
			@RequestParam(value="commentId",required=true)Integer commentId,
			@RequestParam(value="parentId",required=true)Integer parentId) {
		Comment comment = new Comment();
		comment.setId(commentId);
		User user = new User();
		user.setUserId(replyUserId);
		ReplyComment parent = new ReplyComment();
		parent.setReplyId(parentId);
		ReplyComment replyComment = new ReplyComment();
		replyComment.setReplyContent(replyContent);
		replyComment.setReplyTime(DateUtil.getCurrentTimes());
		replyComment.setComment(comment);
		replyComment.setReplyUser(user);
		replyComment.setReplyComment(parent);
		String str = "OK";
		int i = replyCommentService.insertReplyToReply(replyComment);
		if(i > 0) {
			System.out.println("回复的回复添加成功");
			parent = replyCommentService.queryReplyCommentById2(parentId);
			if(parent.getReplyUser().getUserId() != replyUserId) {
				int j = mailMyCommentService.addMailMyCommentService(parent.getReplyUser().getUserId(), null, replyComment.getReplyId(), 'R');
				if(j > 0) {
					System.out.println("[回复的回复]通知添加成功");
				}else {
					System.out.println("[回复的回复]通知添加失败");
				}
			}
		}else {
			str = "ERROR";
			System.out.println("回复的回复添加失败");
		}
		return str;
	}
	
	

}
