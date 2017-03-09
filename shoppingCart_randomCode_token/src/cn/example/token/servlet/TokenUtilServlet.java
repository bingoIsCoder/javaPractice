package cn.example.token.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.example.token.util.TokenUtil;

@WebServlet("/tokenUtil")
public class TokenUtilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		TokenUtil.createToken(req, "TOKEN_IN_SESSION", "token");
		req.getRequestDispatcher("/token/token.jsp").forward(req, resp);
	}
}
