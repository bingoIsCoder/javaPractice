package cn.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.example.util.Global;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//将当前登陆用户从senssion中删除
		
		req.getSession().removeAttribute(Global.USER_IN_SENSSION);
		
		//跳转到登陆页面
		resp.sendRedirect("/login.jsp");
	}

}


