package cn.example.randomcode.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.example.randomcode.util.RandomCodeUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		

		if (!RandomCodeUtil.equalsRandomCode(req, "code", "RANDOMCODE_IN_SESSION")) {
			req.setAttribute("errorMsg", "验证码输入错误...");
			req.getRequestDispatcher("/randomcode/login.jsp").forward(req, resp);
			return;
		}
		System.out.println("OK");
	}

}
