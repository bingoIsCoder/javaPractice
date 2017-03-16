package cn.example.uploadFile.util;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class FileUtil {
	public static final String[] IMG_EXTS = {"jpg", "jpeg", "png", "bmp"};
	
	public static void uploadFile(HttpServletRequest req, Map<String, String> feildMap, Map<String, CFile> fileMap) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			// Parse the request
			List<FileItem> items = upload.parseRequest(req);
			for (FileItem fileItem : items) {
				if (fileItem.isFormField()) {
					feildMap.put(fileItem.getFieldName(), fileItem.getString("UTF-8"));
				} else {					
					String reqFileName = fileItem.getName();
					if (!req.getServletContext().getMimeType(FilenameUtils.getName(reqFileName)).startsWith("image/")) {
						throw new RuntimeException("只能上传图片类型...");
					}
					String extName = FilenameUtils.getExtension(reqFileName);
					if (!Arrays.asList(IMG_EXTS).contains(extName)) {
						throw new RuntimeException("请上传正确的图片类型...");
					}
					String fileName = UUID.randomUUID().toString() + "." + extName;
					
					String pathName = req.getServletContext().getRealPath("/upload");
					File file = new File(pathName, fileName);
					CFile cFile = new CFile();
					cFile.setName(FilenameUtils.getName(reqFileName));
					cFile.setFilePath(file.getAbsolutePath());
					fileItem.write(file);
					fileMap.put(fileItem.getFieldName(), cFile);
				}
			}
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
}
