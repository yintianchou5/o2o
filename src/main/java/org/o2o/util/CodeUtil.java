package org.o2o.util;

import javax.servlet.http.HttpServletRequest;

//用来验证验证码
public class CodeUtil {
	public static boolean checkVerifyCode(HttpServletRequest request) {
		//获取图片中的验证码
		String verifyCodeExpected=(String)request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		//获取自己填写的验证码
		String verifyCodeActul=HttpServletRequestUtil.getString(request,"verifyCodeActual");
		if(verifyCodeActul==null||!verifyCodeActul.equals(verifyCodeExpected)) {
			return false;
		}
		return true;
	}

}
