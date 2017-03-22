package cn.example.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.example.dao.IProductDao;
import cn.example.domain.Product;
import cn.example.query.PageList;
import cn.example.query.ProductQuery;
import cn.example.util.MyBatisUtil;

public class ProductDaoImpl implements IProductDao{

	@Override
	public List<Product> queryAll(ProductQuery query) {
		SqlSession sqlSession = null;
		List<Product> products = new ArrayList<Product>();
		try {
			sqlSession = MyBatisUtil.INSTANCE.getSqlSession();
			products = sqlSession.selectList("cn.example.domain.ProductMapper.queryAll", query);
			return products;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return null;
	}

	@Override
	public PageList<Product> queryPage(ProductQuery query) {
		SqlSession session = null;
		List<Product> products = new ArrayList<Product>();
		PageList<Product> pageList = null;
		try {
			session = MyBatisUtil.INSTANCE.getSqlSession();
			Integer totalCount = session.selectOne("cn.example.domain.ProductMapper.getCount", query);
			products = session.selectList("cn.example.domain.ProductMapper.queryPage", query);
			pageList = new PageList<Product>(query.getCurrentPage(), query.getPageSize(), totalCount);
			pageList.setData(products);
			return pageList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
