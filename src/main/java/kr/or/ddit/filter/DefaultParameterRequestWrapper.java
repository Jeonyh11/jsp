package kr.or.ddit.filter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class DefaultParameterRequestWrapper extends HttpServletRequestWrapper{
	
	private Map<String, String[]> customMap;

	public DefaultParameterRequestWrapper(HttpServletRequest request) {
		super(request);
		
//		원본 parameter를 복사하여 수정 가능한 Map에 복사
//		request 객체가 원본 파라미터 맵이 아닌, 우리가 만든 맵 객체를 사용할 수 있도록 
//		parameter 관련 메소드 4개 정의
//		wrapper => HttpServletRequestWrapper 클래스 상속

		
		customMap = new HashMap<String, String[]>(request.getParameterMap());
		
		//사정에 의해서 모든 요청객체에 UNT_CD 파라미터로 DDIT 문자열값을 넣어줘야 되는 상황
		customMap.put("UNT_CD", new String[]{"DDIT"});
	}
	
	@Override
	public String getParameter(String name) {
		//키에 해당하는 값 중에 첫번째 값을 반환
		//키에 해당하는 값이 없을 때 ? ==> null
		String[] values = customMap.get(name);
		if(values == null || values.length == 0)
			return null;
		else
		return values[0];
	}

	@Override
	public Map<String, String[]> getParameterMap() {	
		return customMap;
	}
	
	@Override
	public Enumeration<String> getParameterNames() {
		return Collections.enumeration(customMap.keySet());
	}
	
	@Override
	public String[] getParameterValues(String name) {
		return customMap.get(name);
	}
}
