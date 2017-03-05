package cn.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.example.dao.IStudentDAO;
import cn.example.dao.impl.StudentDAOImpl;
import cn.example.domain.Student;

/**
 * 添加数据中转站
 * @author Administrator
 *
 */
@WebServlet("/input")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IStudentDAO dao = new StudentDAOImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String id = req.getParameter("id");
		
		if (id != null ){
			Student stu = dao.findOne(Long.parseLong(id));
			req.setAttribute("stu", stu);
		}
		
		req.getRequestDispatcher("/WEB-INF/student/edit.jsp").forward(req, resp);
	}

}
