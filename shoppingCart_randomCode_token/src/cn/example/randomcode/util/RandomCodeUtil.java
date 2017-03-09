package cn.example.randomcode.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RandomCodeUtil {
	public static boolean equalsRandomCode(HttpServletRequest req, String reqName, String sessionName) {
		String reqCode = req.getParameter(reqName);
		String sessionCode = (String)req.getSession().getAttribute(sessionName); 
		req.getSession().removeAttribute(sessionName);
		return reqCode.equals(sessionCode);
	}
	
	public static void createCode(HttpServletRequest req, HttpServletResponse resp, String codeName) {
		String randomCode = UUID.randomUUID().toString().substring(0, 5);
		req.getSession().setAttribute(codeName, randomCode);
		
		//创建图像
		int width = 80;
		int height = 30;
		int imageType = BufferedImage.TYPE_INT_BGR;
		BufferedImage image = new BufferedImage(width, height, imageType);
		
		//画板
		Graphics g = image.getGraphics();
		g.setColor(Color.YELLOW);
		//绘制实心的矩形
		g.fillRect(0, 0, width, height);
		
		//把随机数画进图片
		g.setColor(Color.red);
		g.setFont(new Font("宋体", Font.BOLD + Font.ITALIC, 20));
		g.drawString(randomCode, 10, 20);
		//干扰线
		g.setColor(Color.GRAY);
		Random r = new Random();
		for (int i = 0; i < 150; i++) {
			g.fillRect(r.nextInt(width), r.nextInt(height), 2, 2);
		}
		
		//关闭
		g.dispose();
		//保存图片（以流的方式）
		try {
			ImageIO.write(image, "jpg", resp.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
