package com.cy.answer.utils;

import org.apache.commons.lang.StringUtils;

/**
 * String工具类
 * @author cql
 *
 */
public class StringUtil {
	
	/**
	 * 对N个String变量进行判断（若其中没有null  ""  " " 则返回false，否则返回true）
	 * @param arg
	 * @return
	 */
	public static boolean isEmpty (String...arg) {
		if(null == arg) {
			return true;
		}
		
		for(int i=0; i<arg.length; i++) {
			if(null == arg[i]) {
				return true;
			}
			if( StringUtils.isEmpty(arg[i]) ) {
				return true;
			}
		}
		
		return false;
	}
}
