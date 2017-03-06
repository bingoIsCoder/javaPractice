package cn.example.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.example.dao.IStudentDAO;
import cn.example.domain.Student;
import cn.example.util.JDBCUtil;

public class StudentDAOImpl extends BaseDAOImpl<Student> implements IStudentDAO {

	@Override
	public void save(Student stu) {
		super.executeUpdate("insert into student (name, age) values(?,?)", stu.getName(), stu.getAge());
	}

	@Override
	public void update(Student stu) {
		super.executeUpdate("update student set name=?, age=? where id=?",
				stu.getName(), stu.getAge(), stu.getId());
	}

	@Override
	public void delete(Long id) {
		super.executeUpdate("delete from student where id=? ", id);
	}

	@Override
	public Student findOne(Long id) {
		return super.executeOne("select * from student where id=?", Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		return super.executeAll("select * from student", Student.class);
	}

	@Override
	public Student login(String name, String password) {
		Student stu = null;	
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getInstance().getConnection();
			st = conn.prepareStatement("select * from student where name=? and password=?");
			st.setObject(1, name);
			st.setObject(2, password);
			rs = st.executeQuery();
			while (rs.next()) {
				stu = new Student();
				stu.setId(rs.getLong("id"));
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.getInstance().close(rs, st, conn);
		}
		return stu;
	}
	
}
