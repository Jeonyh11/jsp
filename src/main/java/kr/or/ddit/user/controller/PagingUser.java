package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/pagingUser")
public class PagingUser extends HttpServlet{

	private UserServiceI userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pageParam = req.getParameter("page");
		String pageSizeParam = req.getParameter("pageSize");
		
//		int page = 0;
//		
//		if(pageParam == null) {
//			page = 1;
//		} else {
//			page = Integer.parseInt(pageParam);
//		}
// 		==> (삼항연산자로 변경)
		int page = pageParam == null ? 1 : Integer.parseInt(pageParam);
		
		
//		int pageSize = 0;
//		
//		if(pageSizeParam == null ) {
//			pageSize = 5;
//		} else {
//			pageSize = Integer.parseInt(pageSizeParam);
//		}
		
		int pageSize = pageSizeParam == null ? 5 : Integer.parseInt(pageSizeParam);
		
		PageVo vo = new PageVo(page, pageSize);
		
		Map<String, Object> map = userService.selectPagingUser(vo);
		
		List<UserVo> userList = (List<UserVo>)map.get("userList");
		int userCnt = (int)map.get("userCnt");
		
		int pagination = (int)Math.ceil((double)userCnt/pageSize);
		
		req.setAttribute("userList", userList);
		req.setAttribute("userCnt", pagination);
		
		
		
		req.getRequestDispatcher("/user/pagingUser.jsp").forward(req, resp);
		
	}
}
