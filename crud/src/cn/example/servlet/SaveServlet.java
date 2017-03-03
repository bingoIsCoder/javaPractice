package cn.example.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.example.dao.IStudentDAO;
import cn.example.dao.impl.StudentDAOImpl;
import cn.example.domain.Student;

@WebServlet("/save")
public class SaveServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		Student stu = new Student();
		Map<String, String[]> map = req.getParameterMap();
		try {
			BeanUtils.copyProperties(stu, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		IStudentDAO sti = new StudentDAOImpl();
		sti.save(stu);
		
		req.getRequestDispatcher("/list").forward(req, resp);
	}

}
