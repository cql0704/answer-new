package com.cy.answer.dao;

import com.cy.answer.model.UserAnswerRecord;

public interface UserAnswerRecordDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAnswerRecord record);

    int insertSelective(UserAnswerRecord record);

    UserAnswerRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAnswerRecord record);

    int updateByPrimaryKey(UserAnswerRecord record);
    
    /**
     * 根据用户id查找用户答题记录
     * @param userId
     * @return
     */
    UserAnswerRecord selectByUserId (int userId);
}