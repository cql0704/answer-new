package com.cy.answer.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.answer.dao.UserAnswerRecordDao;
import com.cy.answer.dao.UserInfoDao;
import com.cy.answer.exception.BizException;
import com.cy.answer.model.UserAnswerRecord;
import com.cy.answer.model.UserInfo;


@Service
public class UserInfoService {
	
	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	private UserAnswerRecordDao userAnswerRecordDao;
	
	
	/**
	 * 保存或更新用户信息
	 * @param wxId
	 * @param headImage
	 * @param nickName
	 * @return
	 * @throws BizException 
	 */
	@Transactional
	public int saveOrUpdateUser(String wxId, String headImage, String nickName) throws BizException {
		if(null == wxId || null == headImage || null == nickName) {
			throw new BizException("用户信息错误");
		}
		//根据微信id查找用户
		UserInfo userInfo = userInfoDao.selectByWxId(wxId);
		
		//用户未在本系统注册，进行保存操作
		if(null == userInfo) {
			userInfo = new UserInfo();
			userInfo.setWxId(wxId);
			userInfo.setHeadImage(headImage);
			userInfo.setNickName(nickName);
			userInfo.setRegistTime(new Date());
			userInfo.setLastLoginTime(new Date());
			int len = userInfoDao.insert(userInfo);
			//用户信息保存失败
			if (1 != len ) {
				throw new BizException("保存用户信息失败");
			}
			
			//初始化一条用户答题记录
			UserAnswerRecord userAnswerRecord = new UserAnswerRecord();
			userAnswerRecord.setUserId(userInfo.getUserId());
			userAnswerRecord.setUpdateTime(new Date());
			int recordLen = userAnswerRecordDao.insertSelective(userAnswerRecord);
			if (1 != recordLen ) {
				throw new BizException("初始化用户答题记录失败");
			}
						
		//用户已经注册判断是否需要更新	
		} else {
			//头像和昵称有变化
			if( !(headImage.equals(userInfo.getHeadImage()) && nickName.equals(userInfo.getNickName())) ) {
				userInfo.setHeadImage(headImage);
				userInfo.setNickName(nickName);
			}
			//更新最后登录时间
			userInfo.setLastLoginTime(new Date());
			int len = userInfoDao.updateByPrimaryKeySelective(userInfo);
			//用户信息保存失败
			if (1 != len ) {
				throw new BizException("更新用户信息失败");
			}
		}
		return userInfo.getUserId();
	}
	
	
	/**
	 * 检查用户是否存在
	 * @param userId
	 * @return
	 */
	public boolean checkUserById (int userId) {
		UserInfo userInfo = userInfoDao.selectByPrimaryKey(userId);
		if( null != userInfo ){
			return true;
		}
		return false;
	}
}
