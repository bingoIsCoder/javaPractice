package cn.example.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.example.dao.IStudentDAO;
import cn.example.dao.impl.StudentDAOImpl;
import cn.example.domain.Student;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IStudentDAO dao = new StudentDAOImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");	

		Student stu = (Student)req.getSession().getAttribute("USER_IN_SENSSION");
		if (stu == null) {
			resp.sendRedirect("/login.jsp");
			return;
		}
		
		String cmd = req.getParameter("cmd");
		
		if ("list".equals(cmd)) {
			this.list(req, resp);
		} else if ("edit".equals(cmd)) {
			this.edit(req, resp);
		} else if ("input".equals(cmd)) {
			this.input(req, resp);
		} else if ("delete".equals(cmd)) {
			this.delete(req, resp);
		}
	}
	
	public void list(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Student> stus = dao.findAll();
		req.setAttribute("stus", stus);
		
		req.getRequestDispatcher("/WEB-INF/student/list.jsp").forward(req, resp);
	}
	
	public void edit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		
		Student stu = new Student();
		stu.setName(req.getParameter("name"));
		stu.setAge(Integer.parseInt(req.getParameter("age")));
		if (id != null && !"".equals(id)) {
			stu.setId(Long.parseLong(id));
			dao.update(stu);
		}
		else {
			dao.save(stu);
		}
		
		resp.sendRedirect(req.getContextPath() + "/student?cmd=list");
	}
		
	
	public void input(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		
		if (id != null ){
			Student stu = dao.findOne(Long.parseLong(id));
			req.setAttribute("stu", stu);
		}
		
		req.getRequestDispatcher("/WEB-INF/student/edit.jsp").forward(req, resp);		
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		dao.delete(Long.parseLong(req.getParameter("id")));		
		resp.sendRedirect(req.getContextPath() + "/student?cmd=list");
	}
	
}
