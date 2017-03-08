package cn.example.shopping.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.example.shopping.domain.BuyCart;
import cn.example.shopping.domain.CartItem;

@WebServlet("/shoppingCart")
public class ShoppingCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String cmd = req.getParameter("cmd");
		
		if ("add".equals(cmd)) {
			this.add(req, resp);
		} else if ("delete".equals(cmd)) {
			this.delete(req, resp);
		}
	}
	
	public void add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BuyCart buyCart = (BuyCart)req.getSession().getAttribute("BUYCART_IN_SESSION");
		if (buyCart == null) {
			buyCart = new BuyCart();
			req.getSession().setAttribute("BUYCART_IN_SESSION", buyCart);
		}
		
		String name = req.getParameter("name");
		String num = req.getParameter("num");
		CartItem newItem = new CartItem();
		newItem.setNum(Integer.parseInt(num));
		newItem.setName(name);
		
		switch (name) {
		case "手机":
			newItem.setId("A");
			newItem.setPrice(6666.66D);
			break;
		case "电脑":
			newItem.setId("B");
			newItem.setPrice(9999.99D);
			break;
		case "显示器":
			newItem.setId("C");
			newItem.setPrice(2222.66D);
			break;	
		case "平板":
			newItem.setId("D");
			newItem.setPrice(4444.99D);
			break;
		case "耳机":
			newItem.setId("E");
			newItem.setPrice(999.99D);
			break;
		
		default:
			break;
		}
		buyCart.addItem(newItem);
		resp.sendRedirect("/shoppingCart.jsp");
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		BuyCart buyCart = (BuyCart)req.getSession().getAttribute("BUYCART_IN_SESSION");
		if (buyCart != null)
			buyCart.deleteItem(id);
		resp.sendRedirect("/shoppingCart.jsp");
	}
}
