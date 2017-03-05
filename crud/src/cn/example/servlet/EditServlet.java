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

@WebServlet("/edit")
public class EditServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IStudentDAO dao = new StudentDAOImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		
		Student stu = new Student();
		Map<String, String[]> map = req.getParameterMap();
		try {
			BeanUtils.copyProperties(stu, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(stu);
		if (id != null && !"".equals(id))
			dao.update(stu);
		else {
			dao.save(stu);
		}
		
		resp.sendRedirect(req.getContextPath() + "/list");
	}

}
