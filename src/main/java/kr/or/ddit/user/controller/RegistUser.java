package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;
import kr.or.ddit.util.FileUtil;

@MultipartConfig
@WebServlet("/registUser")
public class RegistUser extends HttpServlet{
	
	private UserServiceI userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/user/registUser.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String userid = req.getParameter("userid");
		String usernm = req.getParameter("usernm");
		String pass = req.getParameter("pass");
		Date reg_dt = new Date();
		String alias = req.getParameter("alias");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String zipcode = req.getParameter("zipcode");
		
		//사용자가 profile을 업로드 한경우
		//전송한 파일 이름 (filename)
		//파일 확장자
		//서버에 저장할 파일 이름(realfilename)
		//서버에 지정된 공간에 저장
		
		

		Part profile = req.getPart("profile");
		String filename ="";
		String realfilename="";
		if(profile.getSize() > 0) {
			filename = FileUtil.getFileName(profile.getHeader("Content-Disposition"));
			String fileExtension = FileUtil.getFileExtension(filename);
			//brown / brown.png  .이 있는 경우 없는 경우
			realfilename = UUID.randomUUID().toString() + fileExtension;
			
			//업로드
			profile.write("d:\\upload\\" + realfilename);
		}
		
		UserVo userVo = new UserVo(userid, usernm, pass, reg_dt, alias, addr1, addr2, zipcode, filename, realfilename);
		
		int insertCnt = 0;
		
		try {
			insertCnt = userService.insertUser(userVo);
		} catch (Exception e) {
			insertCnt = 0;
		}
		
		
		if(insertCnt == 1) {
			
			resp.sendRedirect(req.getContextPath()+"/pagingUser");

		} else {	
			
			doGet(req, resp);
			
		}
		
	}
}
