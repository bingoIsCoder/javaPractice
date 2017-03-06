package cn.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import cn.example.dao.IStudentDAO;
import cn.example.dao.impl.StudentDAOImpl;
import cn.example.domain.Student;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IStudentDAO dao = new StudentDAOImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String name =req.getParameter("name");
		String password = req.getParameter("password");
		
		Student stu = dao.login(name, password);
		if (stu == null) {
			req.setAttribute("errorMsg", "登陆失败...");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		req.getSession().setAttribute("USER_IN_SENSSION", stu);
		resp.sendRedirect(req.getContextPath() + "/list");
	}

}
