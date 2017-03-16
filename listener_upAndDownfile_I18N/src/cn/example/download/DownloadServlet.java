package cn.example.download;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String fileName = req.getParameter("name");
		String encodingFileName = null;
		String path = req.getServletContext().getRealPath("/WEB-INF/download");
		File file = new File(path, fileName);
		
		String userAgent = req.getHeader("User-Agent");
		//IE
		if (userAgent.contains("MSIE")) {
			encodingFileName = URLEncoder.encode(fileName, "UTF-8");
		} else {
			//Other browser
			encodingFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}
		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Disposition", "attachment;filename="+encodingFileName);
		Files.copy(Paths.get(file.getAbsolutePath()), resp.getOutputStream());
	}

}
