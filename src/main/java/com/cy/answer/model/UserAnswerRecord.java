package com.cy.answer.model;

import java.util.Date;

public class UserAnswerRecord {
	//主键id
    private Integer id;
    //用户id
    private Integer userId;
    //答题总数
    private Integer answerAmount;
    //正确数量
    private Integer rightAmount;
    //更新时间
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAnswerAmount() {
        return answerAmount;
    }

    public void setAnswerAmount(Integer answerAmount) {
        this.answerAmount = answerAmount;
    }

    public Integer getRightAmount() {
        return rightAmount;
    }

    public void setRightAmount(Integer rightAmount) {
        this.rightAmount = rightAmount;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}