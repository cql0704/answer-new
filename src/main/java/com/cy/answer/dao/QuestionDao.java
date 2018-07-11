package com.cy.answer.dao;

import com.cy.answer.model.Question;

public interface QuestionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
    
    /**
     * 从题库中随机选一题
     * @return
     */
    Question randomOneQuestion();
}