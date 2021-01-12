package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public class UserServiceTest {

	// 전체 사용자 조회 테스트
		@Test
		public void selectAllUserTest() {
			/***Given***/
			UserServiceI userService = new UserService();
			/***When***/
			List<UserVo> userList = userService.selectAllUser();

			/***Then***/
			assertEquals(16, userList.size());
		}

		
		// 사용자 아이디를 이용하여 특정 사용자 정보 조회
		@Test
		public void selectUserTest() {
			/***Given***/
			UserServiceI userService = new UserService();
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
			UserServiceI userService = new UserService();
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
			UserServiceI userService = new UserService();
			PageVo page = new PageVo(2, 5);
			
			/***When***/
			Map<String, Object> map = userService.selectPagingUser(page);
			
			List<UserVo> userList = (List<UserVo>)map.get("userList");
			
			/***Then***/
			assertEquals(5, userList.size());
		}

}
