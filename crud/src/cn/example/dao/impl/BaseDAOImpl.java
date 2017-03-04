package cn.example.dao.impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.example.util.JDBCUtil;

public class BaseDAOImpl<T> {
	public void executeUpdate(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = JDBCUtil.getInstance().getConnection();
			st = conn.prepareStatement(sql);
			for (int i = 1; i <= params.length; i++) {
				st.setObject(i, params[i-1]);
			}
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.getInstance().close(null, st, conn);
		}
	}
	
	public T executeOne(String sql, Class<T> clz, Object... params) {
		Connection conn = null;
		PreparedStatement st = null;
		T obj = null;
		try {
			obj = clz.newInstance();
			conn = JDBCUtil.getInstance().getConnection();
			st = conn.prepareStatement(sql);
			for (int i = 1; i <= params.length; i++) {
				st.setObject(i, params[i-1]);
			}
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				obj = res2Obj(rs, clz);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.getInstance().close(null, st, conn);
		}
		return obj;
	}
	
	public List<T> executeAll(String sql, Class<T> clz) {
		Connection conn = null;
		PreparedStatement st = null;
		List<T> objs = new ArrayList<T>();
		try {
			conn = JDBCUtil.getInstance().getConnection();
			st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				objs.add(res2Obj(rs, clz));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.getInstance().close(null, st, conn);
		}
		return objs;
	}
	
	public T res2Obj(ResultSet rs, Class<T> clz) {
		T obj = null;
		try {
			obj = clz.newInstance();
			BeanInfo beanInfo = Introspector.getBeanInfo(clz, Object.class);
			PropertyDescriptor[] pd = beanInfo.getPropertyDescriptors();			
			for (PropertyDescriptor propertyDescriptor : pd) {
				Method method = propertyDescriptor.getWriteMethod();
				method.invoke(obj, rs.getObject(propertyDescriptor.getName()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
}
