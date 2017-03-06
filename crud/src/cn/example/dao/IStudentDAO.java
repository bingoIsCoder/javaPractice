package cn.example.dao;

import java.util.List;

import cn.example.domain.Student;

public interface IStudentDAO {
	/**
	 * 添加数据
	 * @param stu
	 */
	public void save(Student stu);
	/**
	 * 修改数据
	 * @param stu
	 */
	public void update(Student stu);
	/**
	 * 删除数据
	 * @param id
	 */
	public void delete(Long id);
	/**
	 * 查询一条数据
	 * @param id
	 * @return
	 */
	public Student findOne(Long id);
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<Student> findAll();
	/**
	 * 登陆
	 * @param name 用户名
	 * @param password 密码
	 * @return
	 */
	Student login(String name, String password);
	
}
