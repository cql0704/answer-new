package com.cy.answer.service;


import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.answer.constant.TypeConstant;
import com.cy.answer.dao.QuestionDao;
import com.cy.answer.dao.UserAnswerLogDao;
import com.cy.answer.dao.UserAnswerRecordDao;
import com.cy.answer.dao.UserInfoDao;
import com.cy.answer.exception.BizException;
import com.cy.answer.model.Question;
import com.cy.answer.model.UserAnswerLog;
import com.cy.answer.model.UserAnswerRecord;
import com.cy.answer.model.UserInfo;


@Service
public class QuestionService {
	
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	private UserAnswerLogDao userAnswerLogDao;
	@Autowired
	private UserAnswerRecordDao userAnswerRecordDao;
	
	/**
	 * 随机出题
	 * @return
	 */
	public Question randomSetQuestion() {		
		Question question = questionDao.randomOneQuestion();
		return question;
	}
	
	
	/**
	 * 校验答案
	 * @param userId
	 * @param questionId
	 * @param answer
	 * @return
	 * @throws BizException 
	 */
	@Transactional
	public boolean checkAnswer (int userId, int questionId, String answer) throws BizException {
		//参数检查
		if(userId == 0 || questionId == 0 || null == answer ) {
			throw new BizException("参数错误");
		}		
		//校验用户是否存在
		UserInfo userInfo = userInfoDao.selectByPrimaryKey(userId);
		if( null == userInfo ) {
			throw new BizException("用户不存在");
		}		
		//校验题目是否存在
		Question question = questionDao.selectByPrimaryKey(questionId);
		if( null == question ) {
			throw new BizException("题目不存在");
		}
		
		//校验用户答题记录是否存在
		UserAnswerRecord userAnswerRecord = userAnswerRecordDao.selectByUserId(userId);
		if( null == userAnswerRecord ) {
			throw new BizException("用户答题记录不存在");
		}
		
		boolean resultFlag = false;		
		//插入一条答题流水		
		UserAnswerLog userAnswerLog = new UserAnswerLog();
		userAnswerLog.setUserId(userId);
		userAnswerLog.setQuestionId(questionId);
		userAnswerLog.setCreateTime(new Date());
		userAnswerLog.setUserAnswer(answer);
		
		//校验答案
		//回答正确
		if(answer.equals(question.getAnswer())) {
			//设置答题流水表结果
			userAnswerLog.setResult(TypeConstant.ANSWER_RESULT_SUCCESS);
			//设置用户答题记录表的答对题目数
			userAnswerRecord.setRightAmount(userAnswerRecord.getRightAmount() + 1 );
			resultFlag = true;
		}else {
			//回答错误
			userAnswerLog.setResult(TypeConstant.ANSWER_RESULT_FAILED);
		}
		
		//插入一条用户答题流水
		int len = userAnswerLogDao.insert(userAnswerLog);
		if( 1 != len ) {
			throw new BizException("插入用户答题流水失败");
		}
		
		//更新用户答题记录
		userAnswerRecord.setUserId(userId);
		userAnswerRecord.setUpdateTime(new Date());
		//用户答题总数增加一条
		userAnswerRecord.setAmount(userAnswerRecord.getAmount() + 1);
		
		int updateLen = userAnswerRecordDao.updateByPrimaryKey(userAnswerRecord);
		if( 1 != updateLen ) {
			throw new BizException("更新用户答题流水失败");
		}
		
		return resultFlag;
	}
}
