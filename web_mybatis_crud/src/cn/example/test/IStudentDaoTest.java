package cn.example.test;

import java.util.List;

import org.junit.Test;

import cn.example.dao.IStudentDao;
import cn.example.dao.impl.StudentDaoImpl;
import cn.example.domain.Student;

public class IStudentDaoTest {

	@Test
	public void testSave() {
		IStudentDao dao = new StudentDaoImpl();
		Student stu = new Student();
		stu.setName("binbin");
		stu.setPassword("123aaa");
		stu.setAge(20);
		dao.save(stu);
	}

	@Test
	public void testUpdate() {
		IStudentDao dao = new StudentDaoImpl();
		Student stu = new Student();
		stu.setId(11L);
		stu.setName("madaha");
		stu.setPassword("aaa");
		stu.setAge(30);
		dao.update(stu);
	}

	@Test
	public void testDelete() {
		IStudentDao dao = new StudentDaoImpl();
		dao.delete(15L);
	}

	@Test
	public void testQueryOne() {
		IStudentDao dao = new StudentDaoImpl();
		System.out.println(dao.queryOne(16L));
	}

	@Test
	public void testQueryAll() {
		IStudentDao dao = new StudentDaoImpl();
		List<Student> stus = null;
		stus = dao.queryAll();
		for (Student student : stus) {
			System.out.println(student);
		}
	}

}
