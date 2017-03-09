package cn.example.randomcode.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.example.randomcode.util.RandomCodeUtil;

@WebServlet("/randomCode")
public class RandomCodeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		RandomCodeUtil.createCode(req, resp, "RANDOMCODE_IN_SESSION");
		
		/*
		String randomCode = UUID.randomUUID().toString().substring(0, 5);
		
		req.getSession().setAttribute("RANDOMCODE_IN_SESSION", randomCode);
		
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
		ImageIO.write(image, "jpg", resp.getOutputStream());
		*/
	}
}
