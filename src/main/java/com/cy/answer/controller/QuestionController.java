package com.cy.answer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.answer.constant.FunConstant;
import com.cy.answer.constant.TypeConstant;
import com.cy.answer.exception.BizException;
import com.cy.answer.model.Question;
import com.cy.answer.model.ResultModel;
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
	public ResultModel randomSetQuestion () {
		ResultModel resultModel = new ResultModel();
		try {
			Question question = questionService.randomSetQuestion();
			if(null == question) {
				resultModel.setResultNo(FunConstant.FAILED_NO);
				resultModel.setResultInfo("随机生成题目失败");
				return resultModel;
			}
			
			resultModel.getResultMap().put("question", question);
			resultModel.setResultInfo("获取随机题目成功");
			
		} catch (Exception e) {
			e.printStackTrace();
			resultModel.setResultNo(FunConstant.FAILED_NO);
			resultModel.setResultInfo("随机生成题目失败");
			return resultModel;
		}
		return resultModel;
	}
	

	/**
	 * 检验答案
	 * @param userId          用户id
	 * @param questionId      问题id
	 * @param answer          问题答案
	 * @return
	 */
	public ResultModel checkAnswer (int userId, int questionId, String answer) {
		ResultModel resultModel = new ResultModel();		
		try {
			boolean resultFlag = questionService.checkAnswer(userId, questionId, answer);
			//1为正确  0
			resultModel.getResultMap().put("answerResult", resultFlag==true ? TypeConstant.ANSWER_RESULT_SUCCESS:TypeConstant.ANSWER_RESULT_FAILED);
		} catch (BizException e) {
			resultModel.setResultNo(FunConstant.FAILED_NO);
			resultModel.setResultInfo(e.getMessage());
			return resultModel;
		} catch (Exception e) {
			resultModel.setResultNo(FunConstant.FAILED_NO);
			resultModel.setResultInfo("校验答案失败");
			return resultModel;
		}		
		return resultModel;		
	}
	
	
	
	public ResultModel addQuestion () {
		ResultModel resultModel = new ResultModel();
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return resultModel;	
	}
	
}
