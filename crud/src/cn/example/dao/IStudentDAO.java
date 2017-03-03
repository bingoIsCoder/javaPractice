package cn.example.dao;

import java.util.List;

import cn.example.domain.Student;

public interface IStudentDAO {
	public void save(Student stu);
	public void update(Student stu);
	public void delete(Long id);
	public Student findOne(Long id);
	public List<Student> findAll();
}
