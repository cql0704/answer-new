package com.cy.answer.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cy.answer.constant.FunConstant;

/**
 * 接口返回结果集
 * @author cql
 *
 */
public class ResultModel {
	
	private String resultNo;
	private String resultInfo;
	private Map<String, Object> resultMap;
	
	public ResultModel () {
		resultNo = FunConstant.SUCCESS_No;
		resultInfo = "成功";
		resultMap = new HashMap<String, Object>();
	}
	
	public String getResultNo() {
		return resultNo;
	}
	public void setResultNo(String resultNo) {
		this.resultNo = resultNo;
	}
	public String getResultInfo() {
		return resultInfo;
	}
	public void setResultInfo(String resultInfo) {
		this.resultInfo = resultInfo;
	}
	public Map<String, Object> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	@Override
	public String toString() {
		return "ResultModel [resultNo=" + resultNo + ", resultInfo="
				+ resultInfo + ", resultMap=" + resultMap + "]";
	}
	
 }
