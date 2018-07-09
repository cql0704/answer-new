package com.cy.answer.service;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.answer.dao.QuestionMapper;
import com.cy.answer.model.Question;


@Service
public class QuestionService {
	
	@Autowired
	private QuestionMapper questionDao;
	
	
	/**
	 * 随机出题
	 * @return
	 */
	public Question randomSetQuestion() {		
		Question question = questionDao.randomOneQuestion();
		return question;
	}
}
