package com.java1234.util;

/**
 * �ַ���������
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
	 * �жϿշ�
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
