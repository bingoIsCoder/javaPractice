package cn.example.dao.impl;


import java.util.List;

import org.junit.Test;

import cn.example.domain.Student;

public class StudentDAOImplTest extends StudentDAOImpl {

	@Test
	public void testSave() {
		Student student = new Student();
		student.setName("liu");
		student.setAge(11);
		save(student);
	}

	@Test
	public void testUpdate() {
		Student student = new Student();
		student.setName("binbin");
		student.setAge(18);
		student.setId(1L);
		update(student);
	}

	@Test
	public void testDelete() {
		delete(1L);
	}

	@Test
	public void testFindOne() {
		Student findOne = findOne(2L);
		System.out.println(findOne);
	}

	@Test
	public void testFindAll() {
		List<Student> findAll = findAll();
		for (Student student : findAll) {
			System.out.println(student);
		}
	}

}
