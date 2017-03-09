package cn.example.token.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.example.token.util.TokenUtil;

@WebServlet("/token")
public class TokenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		if (!TokenUtil.equalsToken(req, "TOKEN_IN_SESSION", "token")) {
			System.out.println("No more salary");
			return;
		}
		
		String salary = req.getParameter("salary");
		System.out.println("发发发..." + salary);
	}
}
