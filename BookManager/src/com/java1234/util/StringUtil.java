package com.java1234.util;

/**
 * 字符串工具类
 * @author s1841
 *
 */
public class StringUtil {

	public static boolean isEmpty(String str){
		if(str==null||"".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}


	/**
	 * 判断空否
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		if(str!=null&&!"".equals(str.trim())){
			return true;
		}else
			return false;
	}
}
