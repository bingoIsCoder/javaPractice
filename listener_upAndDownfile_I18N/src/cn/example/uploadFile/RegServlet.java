package cn.example.uploadFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class RegServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		//System.out.println(isMultipart);
		
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			// Parse the request
			List<FileItem> items = upload.parseRequest(req);
			for (FileItem fileItem : items) {
				if (fileItem.isFormField()) {
					//System.out.println(fileItem.getName());
					System.out.println(fileItem.getFieldName() + ": " + fileItem.getString("UTF-8"));
					System.out.println("----------------");
				} else {
					//System.out.println(fileItem.getName());
					//System.out.println(fileItem.getFieldName());
					String reqFileName = fileItem.getName();
					if (!super.getServletContext().getMimeType(reqFileName).startsWith("image/")) {
						req.setAttribute("errorMsg", "请上传正确文件...");
						req.getRequestDispatcher("/reg.jsp").forward(req, resp);
						return;
					}
					String extName = FilenameUtils.getExtension(fileItem.getName());
					String fileName = UUID.randomUUID().toString() + "." + extName;
					
					String pathName = super.getServletContext().getRealPath("/upload");
					File file = new File(pathName, fileName);
					fileItem.write(file);
				}
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
}
