package com.cy.answer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.answer.constant.FunConstant;
import com.cy.answer.model.Question;
import com.cy.answer.service.QuestionService;


/**
 * 
 * @author cql
 *
 */
@Controller
@RequestMapping("question/")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	/**
	 * 随机出题
	 * @return
	 */
	@ResponseBody
	@RequestMapping("FUN-ANSWER-002")
	public Map<String, Object> randomSetQuestion () {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			Question question = questionService.randomSetQuestion();
			if(null == question) {
				resultMap.put(FunConstant.RESULT_FIELD, FunConstant.FAILED_NO);
				resultMap.put(FunConstant.RESULT_INFO,"出题失败");
				return resultMap;
			}
			
			resultMap.put(FunConstant.RESULT_MAP, question);			
			resultMap.put(FunConstant.RESULT_FIELD, FunConstant.SUCCESS_No);
			resultMap.put(FunConstant.RESULT_INFO, "获取随机题目成功");
			
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put(FunConstant.RESULT_FIELD, FunConstant.FAILED_NO);
			resultMap.put(FunConstant.RESULT_INFO,"出题失败");
			return resultMap;
		}
		return resultMap;
	}
	
}
