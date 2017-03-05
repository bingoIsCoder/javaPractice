package cn.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.example.dao.IStudentDAO;
import cn.example.dao.impl.StudentDAOImpl;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IStudentDAO dao = new StudentDAOImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		dao.delete(Long.parseLong(req.getParameter("id")));
		
		resp.sendRedirect(req.getContextPath() + "/list");
	}

}
