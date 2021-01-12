package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.EmpVo;
import kr.or.ddit.user.model.UserVo;

public interface UserServiceI {
	
	// 전체 사용자 정보 조회
	List<UserVo> selectAllUser();
	
	// userid에 해당하는 사용자 한명의 정보 조회
	UserVo selectUser(String userid);
	
	// 페이지에 맞는 사용자 정보 조회
	Map<String, Object> selectPagingUser(PageVo vo);
	
	// 전체 직원 정보 조회
	List<EmpVo> selectAllEmp();
	
}
