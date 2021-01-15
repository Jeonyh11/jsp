package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public class UserServiceTest {
	

	private UserServiceI userService;
	
	
	@Before
	public void setup() {
		userService = new UserService();
		// 테스트에서 사용할 신규 사용자 추가
		UserVo userVo = new UserVo("testUser", "테스트용", "1234", new Date(), "테스트",
							 		"대전시 중구 중앙로79", "4층", "34940");
		
		userService.insertUser(userVo);
		
		// 신규 입력  테스트를 위해 테스트 과정에서 입력된 데이터를 삭제
		userService.deleteUser("ddit_n");
	}
	
	@After
	public void tearDown() {
		userService.deleteUser("testUser");
	}
	
	
	// 전체 사용자 조회 테스트
	@Test
	public void selectAllUserTest() {
		/***Given***/
		
		/***When***/
		List<UserVo> userList = userService.selectAllUser();

		/***Then***/
		assertEquals(18, userList.size());
	}

		
	// 사용자 아이디를 이용하여 특정 사용자 정보 조회
	@Test
	public void selectUserTest() {
		/***Given***/
		String userid="brown";

		/***When***/
		UserVo user = userService.selectUser(userid);
			
		/***Then***/
		assertNotNull(user);	// null이 아닌지 확인
		assertEquals("브라운", user.getUsernm());
			
	}
		
	// 사용자 아이디가 존재하지 않을 때 특정 사용자 조회
	@Test
	public void selectUserNotExsistTest() {
		/***Given***/
		String userid="b";

		/***When***/
		UserVo user = userService.selectUser(userid);
					
		/***Then***/
		assertNull(user);
	}
		
	
	// 페이징 처리하여 사용자 정보 조회
	@Test
	public void selectPagingUserTest() {
			
		/***Given***/
		PageVo page = new PageVo(2, 5);
			
		/***When***/
		Map<String, Object> map = userService.selectPagingUser(page);
			
		List<UserVo> userList = (List<UserVo>)map.get("userList");
		int userCnt = (int)map.get("userCnt");
			
		/***Then***/
		assertEquals(5, userList.size());
		assertEquals(18, userCnt);
	}
		
	
	@Test
	public void modifyUserTest() {
		/***Given***/
		// userid, usernm, pass, reg_dt, alias, addr1, addr2, zipcode
		UserVo userVo = new UserVo("ddit","대덕인재", "dditPass", new Date(),
										"개발원", "대전시 중구 중앙로79", "4층", "34940");

		/***When***/
		int updateCnt = userService.modifyUser(userVo);

		/***Then***/
		assertEquals(1, updateCnt);
	}
		
		
	@Test
	public void registUserTest() {
		/***Given***/
		UserVo userVo = new UserVo("ddit_n", "대덕인재", "dditPass", new Date(), 
										"개발원_m", "대전시 중구 중앙로79", "4층", "34940");

		/***When***/
		int insertCnt = userService.insertUser(userVo);
		

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void deleteUserTest() {
		/***Given***/
		// 해당 테스트가 실행될 때는 testUser라는 사용자가 before메소드에 의해 등록이 된 상태
		String userid = "testUser";
			
		/***When***/
		int deleteCnt = userService.deleteUser(userid);
	
		/***Then***/
		assertEquals(1, deleteCnt);
	}

}
