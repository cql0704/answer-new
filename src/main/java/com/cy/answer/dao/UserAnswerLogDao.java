package com.cy.answer.dao;

import com.cy.answer.model.UserAnswerLog;

public interface UserAnswerLogDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAnswerLog record);

    int insertSelective(UserAnswerLog record);

    UserAnswerLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAnswerLog record);

    int updateByPrimaryKey(UserAnswerLog record);
}