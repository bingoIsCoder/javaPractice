package cn.example.dao.test;


import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import cn.example.dao.IProductDao;
import cn.example.dao.impl.ProductDaoImpl;
import cn.example.domain.Product;
import cn.example.query.ProductQuery;

public class IProductDaoTest {

	@Test
	public void testQueryAll() {
		IProductDao productDao = new ProductDaoImpl();
		ProductQuery query = new ProductQuery();
		query.setName("手机");
		query.setMaxPrice(new BigDecimal(6000));
		query.setMinPrice(new BigDecimal(4000));
		
		List<Product> products = productDao.queryAll(query);
		for (Product product : products) {
			System.out.println(product);
		}
	}
	
	@Test
	public void testQueryPage() {
		
	}

}
