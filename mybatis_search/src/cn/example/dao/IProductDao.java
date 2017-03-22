package cn.example.dao;

import java.util.List;

import cn.example.domain.Product;
import cn.example.query.PageList;
import cn.example.query.ProductQuery;

public interface IProductDao {
	public List<Product> queryAll(ProductQuery query);
	public PageList<Product> queryPage(ProductQuery query);
}
