package kr.or.ddit.servlet.scope;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/scope")
public class Scope extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
//		resp.sendRedirect(req.getContextPath()+"/jsp/scope.jsp");
		req.getRequestDispatcher("/jsp/scope.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String scope = req.getParameter("scope");
		
		req.setAttribute("request", scope+"_request");
		
		
		HttpSession session = req.getSession();
		session.setAttribute("session", scope+"_session");
		
		ServletContext application = getServletContext();
		application.setAttribute("application", scope+"_application");
		
		req.getRequestDispatcher("/jsp/scopeResult.jsp").forward(req, resp);
		
	}
	
	
}
