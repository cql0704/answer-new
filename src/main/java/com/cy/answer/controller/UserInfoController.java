package com.cy.answer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.answer.constant.FunConstant;
import com.cy.answer.exception.BizException;
import com.cy.answer.model.ResultModel;
import com.cy.answer.service.UserInfoService;



/**
 * 用户相关controller
 * @author cql
 *
 */
@Controller
@RequestMapping("userInfo/")
public class UserInfoController {
	
	@Autowired
	private UserInfoService userInfoService;

	/**
	 * 保存或更新用户信息
	 * @param wxId
	 * @param headImage
	 * @param nickName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("FUN-ANSWER-001")
	public ResultModel saveOrUpdateUser(String wxId, String headImage, String nickName){
		ResultModel resultModel = new ResultModel();		
		try {
			int userId = userInfoService.saveOrUpdateUser(wxId, headImage, nickName);
			resultModel.getResultMap().put("userId", userId);
		} catch (BizException e) {
			e.printStackTrace();
			resultModel.setResultNo(FunConstant.FAILED_NO);
			resultModel.setResultInfo(e.getMessage());
			return resultModel;
		} catch (Exception e) {
			e.printStackTrace();
			resultModel.setResultNo(FunConstant.FAILED_NO);
			resultModel.setResultInfo("保存或更新用户信息失败");
			return resultModel;
		}
		
		resultModel.setResultInfo("保存或更新用户信息成功");
		return resultModel;
		
	}
}
