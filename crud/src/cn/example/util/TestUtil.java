package cn.example.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class TestUtil {
	@Test
	public void testJDBC() {
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection connection = JDBCUtil.getInstance().getConnection();
		try {
			st = connection.prepareStatement("select * from student");
			rs = st.executeQuery();
			while (rs.next()) {
				System.out.println((String)rs.getObject("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.getInstance().close(rs, st, connection);
		}
	}
}
