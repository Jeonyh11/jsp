package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.EmpVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/allEmp")
public class AllEmp extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserServiceI userService = new UserService();
		
		List<EmpVo> empList = userService.selectAllEmp();
		
		req.setAttribute("empList", empList);
		
		req.getRequestDispatcher("/user/empList.jsp").forward(req, resp);
	}
}
