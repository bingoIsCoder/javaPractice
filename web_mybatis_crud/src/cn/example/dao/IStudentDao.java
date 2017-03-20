package cn.example.dao;

import java.util.List;

import cn.example.domain.Student;

public interface IStudentDao {
	public void save(Student stu);
	public void update(Student stu);
	public void delete(Long id);
	public Student queryOne(Long id);
	public List<Student> queryAll();
}
