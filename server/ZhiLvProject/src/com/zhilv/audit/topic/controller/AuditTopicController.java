package com.zhilv.audit.topic.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhilv.audit.topic.service.AuditTopicService;
import com.zhilv.entity.AuditTopic;
import com.zhilv.entity.Topic;
import com.zhilv.topic.service.TopicService;
import com.zhilv.util.DateUtil;
import com.zhilv.util.Page;

/**   
 * @ClassName: AuditTopicController   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��19�� ����5:18:17       
 */
@Controller
@RequestMapping("audit/topic")
public class AuditTopicController {
	
	@Resource
	private AuditTopicService auditTopicService;
	
	@Resource
	private TopicService TopicService;
	
	@RequestMapping(value="/list/{pageNum}",method=RequestMethod.GET)
	public String list(@PathVariable(value="pageNum",required=true)int pageNum, Model model) {
		List<AuditTopic> list = auditTopicService.findForPage((pageNum-1)*3, 3);
		Page<AuditTopic> page = new Page<>(pageNum,3);
		page.setList(list);
		page.setTotalCount(auditTopicService.findTopicCount());
		model.addAttribute("page",page);
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String add(@RequestParam("title")String title,@RequestParam("userId")Integer userId) {
		Topic topic = new Topic();
		topic.setTitle(title);
		topic.setUserId(userId);
		int i = auditTopicService.addAuditTopic(topic);
		if(i > 0) {
			System.out.println("��˰滰����ӳɹ�");
			return "OK";
		}else {
			System.out.println("��˰滰�����ʧ��");
			return "ERROR";
		}
	}
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String update(@RequestParam("auditId")Integer auditId,@RequestParam("status")Integer status) {
		int i = auditTopicService.updateTopicStatus(auditId, status, DateUtil.getCurrentTimes());
		if(i > 0) {
			System.out.println("��˰滰��״̬���³ɹ�");
			if(status == 1) { //ͨ���������ӷ����滰��
				AuditTopic auditTopic = auditTopicService.findAuditTopicById(auditId);
				Topic topic = new Topic();
				topic.setTitle(auditTopic.getTitle());
				topic.setUserId(auditTopic.getUserId());
				int j = TopicService.addTopic(topic);
				if(j > 0) {
					System.out.println("���ⷢ���ɹ�");
				}else {
					System.out.println("���ⷢ��ʧ��");
				}
			}
			return "redirect:list/1";
		}else {
			System.out.println("��˰滰��״̬����ʧ��");
			return "redirect:list/1";
		}
	}

}
