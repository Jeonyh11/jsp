package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimesTableServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("		<head>");
		out.println("			<title>TimesTableServlet</title>");
		out.println("			<style>");
		out.println("				td {");
		out.println("					width:130px;");	
		out.println("					height:50px;");	
		out.println("					text-align:center;");	
		out.println("				}");
		out.println("			</style>");
		out.println("		</head>");
		
		out.println("		<body>");
		out.println("			<table border='1'>");
		
		for(int i = 1; i <= 9; i++) {
			out.println("				<tr>");
			for(int j = 2; j <= 9; j++) {
				out.println("<td>");
				out.println(j +" * "+ i+ " = "+ j*i);
				out.println("</td>");
			}
			out.println("				</tr>");
		}
		out.println("			</table>");
		out.println("		</body>");
		out.println("</html>");
		
	}
}
