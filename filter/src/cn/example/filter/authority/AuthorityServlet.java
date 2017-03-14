package cn.example.filter.authority;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class AuthorityServlet extends HttpServlet {
	private static final long serialVersionUID = -7522651858774635325L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		if (name == null || !"admin".equals(name)) {
			req.setAttribute("errorMsg", "用户名错误...");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		HttpSession session = req.getSession();
		session.setAttribute("USER_IN_SESSION", name);
		resp.sendRedirect("/system/welcome.jsp");
	}
}
