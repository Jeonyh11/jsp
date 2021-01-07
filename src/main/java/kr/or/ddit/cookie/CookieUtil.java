package kr.or.ddit.cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(CookieUtil.class);
	/**
	* Method : getCookieValue
	* 작성자 : Sub-02
	* 변경이력 :
	* @param cookieStr
	* @param cookieName
	* @return
	* Method 설명 :	cookieStr에서 cookieName에 해당하는 쿠키 값을 조회
	*/
	// cookieStr : userid=brown; rememberme=Y; test=testcookie
	// cookieName : userid, rememberme
	// return : brown, Y
	public static String getCookieValue(String cookieStr, String cookieName) {
		
		String[] cookies = cookieStr.split("; ");
		
		
		for(String cook : cookies) {	
			String[] cookie = cook.split("=");
			logger.debug("{}",cookie[1]);
			
			if (cookieName.equals(cookie[0])) {
				return cookie[1];
			}
		}
		
		
		return "";
	}
}
