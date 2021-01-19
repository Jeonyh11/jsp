package kr.or.ddit.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationListener implements ServletContextListener{
	private static final Logger logger = LoggerFactory.getLogger(ApplicationListener.class);
	
	//서버가 처음 켜졌을 때
//	${cp } ⇒ ${cp}
//	서버가 기동이 되었을 때
//	application scope에 cp 라는 속성으로 contextPath 값을 저장
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
	logger.debug("INIT");
	ServletContext sc = sce.getServletContext();
	sc.setAttribute("cp", sc.getContextPath());
		
	}

	//서버가 끝났을 때
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		
	}

}
