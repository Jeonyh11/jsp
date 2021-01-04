package kr.or.ddit.servlet.scope;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/mulCalculation")
public class MulCalculation extends HttpServlet{
	
	private static final Logger logger = LoggerFactory.getLogger(MulCalculation.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/Calculation.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int s1 = Integer.parseInt(req.getParameter("param1"));
		int s2 = Integer.parseInt(req.getParameter("param2"));
		
		int result = s1 * s2;
		
		logger.debug("결과 : " + result);
		
		HttpSession session = req.getSession();
		session.setAttribute("mulResult", result);
		
		req.getRequestDispatcher("/jsp/mulResult.jsp").forward(req, resp);
	}
}
