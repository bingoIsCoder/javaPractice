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

@WebServlet("/list")
public class StudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IStudentDAO dao = new StudentDAOImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");	

		List<Student> stus = dao.findAll();
		req.setAttribute("stus", stus);
		
		req.getRequestDispatcher("/WEB-INF/student/list.jsp").forward(req, resp);
	}

}
