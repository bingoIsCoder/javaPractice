package cn.example.dao.impl;

import java.util.List;

import cn.example.dao.IStudentDAO;
import cn.example.domain.Student;

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
	
}
