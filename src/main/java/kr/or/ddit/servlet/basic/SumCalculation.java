package kr.or.ddit.servlet.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/sumCalculation")
public class SumCalculation extends HttpServlet{
	
	private static final Logger logger = LoggerFactory.getLogger(SumCalculation.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/Calculation.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int s = Integer.parseInt(req.getParameter("start"));
		int e = Integer.parseInt(req.getParameter("end"));
		
		int result = sum(s, e);
		
		logger.debug("{}, {}" , "결과", result);
		
		HttpSession session = req.getSession();
		session.setAttribute("sumResult", result);
		
		req.getRequestDispatcher("/jsp/sumResult.jsp").forward(req, resp);
		
	}
	
	public int sum(int a, int b) {
		int sum = 0;
		for(int i = a; i <= b; i++) {
			sum += i;
		}
		return sum;
	}
}
