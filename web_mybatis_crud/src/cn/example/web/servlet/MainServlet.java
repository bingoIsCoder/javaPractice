package cn.example.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.example.dao.IStudentDao;
import cn.example.dao.impl.StudentDaoImpl;
import cn.example.domain.Student;

@WebServlet("/student")
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		if ("list".equals(cmd)) {
			list(req, resp);
		} else if ("input".equals(cmd)) {
			input(req, resp);
		} else if ("delete".equals(cmd)) {
			delete(req, resp);
		} else if ("edit".equals(cmd)) {
			edit(req, resp);
		}
	}
	
	protected void list(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		IStudentDao dao = new StudentDaoImpl();
		List<Student> stus = dao.queryAll();
		
		req.setAttribute("stus", stus);
		req.getRequestDispatcher("/WEB-INF/student/list.jsp").forward(req, resp);
	}
	
	protected void input(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String id = req.getParameter("id");
		if (id != null && !"".equals(id)) {
			IStudentDao dao = new StudentDaoImpl();
			Student stu = dao.queryOne(Long.parseLong(id));
			req.setAttribute("stu", stu);
			req.getRequestDispatcher("/WEB-INF/student/input.jsp").forward(req, resp);
			return;
		}
		req.getRequestDispatcher("/WEB-INF/student/input.jsp").forward(req, resp);
	}
	
	protected void delete(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String id = req.getParameter("id");
		IStudentDao dao = new StudentDaoImpl();
		dao.delete(Long.parseLong(id));
		resp.sendRedirect("/student?cmd=list");
	}
	
	protected void edit(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String age = req.getParameter("age");
		Student stu = new Student();
		stu.setName(name);
		stu.setPassword(password);
		stu.setAge(Integer.parseInt(age));
		IStudentDao dao = new StudentDaoImpl();
		
		if (id != null && !"".equals(id)) {	
			stu.setId(Long.parseLong(id));
			dao.update(stu);
		} else {
			dao.save(stu);
		}
		resp.sendRedirect("/student?cmd=list");
	}
}
