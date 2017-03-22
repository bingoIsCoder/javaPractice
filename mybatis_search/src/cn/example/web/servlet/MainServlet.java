package cn.example.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import cn.example.dao.IProductDao;
import cn.example.dao.impl.ProductDaoImpl;
import cn.example.domain.Product;
import cn.example.query.PageList;
import cn.example.query.ProductQuery;

@WebServlet("/product")
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ProductQuery query = req2Query(req);
		IProductDao dao = new ProductDaoImpl();
		PageList<Product> pageList = dao.queryPage(query);
		req.setAttribute("pageList", pageList);
		req.setAttribute("query", query);
		req.getRequestDispatcher("/WEB-INF/product/product.jsp").forward(req, resp);
	}
	
	private ProductQuery req2Query(HttpServletRequest req) {
		String name = req.getParameter("name");
		String minPrice = req.getParameter("minPrice");
		String maxPrice = req.getParameter("maxPrice");
		String currentPage = req.getParameter("currentPage");
		ProductQuery query = new ProductQuery();
		
		query.setName(name);
		if (StringUtils.isNotBlank(currentPage)) {
			query.setCurrentPage(Integer.parseInt(currentPage));
		}
		
		if (minPrice != null && !"".equals(minPrice)) {
			query.setMinPrice(new BigDecimal(minPrice));
		}
		
		if (maxPrice != null && !"".equals(maxPrice)) {
			query.setMaxPrice(new BigDecimal(maxPrice));
		}
		
		return query;
	}
}
