package cn.example.uploadFile;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.example.uploadFile.util.CFile;
import cn.example.uploadFile.util.FileUtil;


@WebServlet("/reg")
public class RegServletTestUtil extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			Map<String, String> feildMap = new HashMap<String, String>();
			Map<String, CFile> fileMap = new HashMap<String, CFile>();
			FileUtil.uploadFile(req, feildMap, fileMap);
			System.out.println("name: " + feildMap.get("name"));
			System.out.println("password: " + feildMap.get("password"));
			System.out.println(fileMap);
		} catch (RuntimeException e) {
			req.setAttribute("errorMsg", e.getLocalizedMessage());
			req.getRequestDispatcher("/reg.jsp").forward(req, resp);
			return;
		}		
	}
}
