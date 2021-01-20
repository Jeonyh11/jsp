package kr.or.ddit.listener;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;

public class LoginUserListener implements HttpSessionAttributeListener{
	// 2.attribute
//	사용자가 로그인을 할 경우 : S_USER 속성을 session에 추가
//	Set<String>로 로그인한 사용자 아이디를 관리
	private static final Logger logger = LoggerFactory.getLogger(LoginUserListener.class);
	private Set<String> users = new HashSet<String>();
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		if(event.getName().equals("S_USER")) {
			UserVo user = (UserVo)event.getValue();
			logger.debug("add user : {}",user.getUsernm());
			users.add(user.getUsernm());
			event.getSession().getServletContext().setAttribute("USER_SET", users);
		}
		
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		if(event.getName().equals("S_USER")) {
		UserVo user = (UserVo) event.getValue();
		logger.debug("removed user : {}",user.getUsernm());
		users.remove(user.getUsernm());
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		
		
	}

}
