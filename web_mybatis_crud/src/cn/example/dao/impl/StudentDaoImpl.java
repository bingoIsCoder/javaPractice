package cn.example.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.example.dao.IStudentDao;
import cn.example.dao.util.MyBatisUtil;
import cn.example.domain.Student;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public void save(Student stu) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.INSTANCE.openSession();
			session.insert("cn.example.domain.StudentMapper.save", stu);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();			
		}
	}

	@Override
	public void update(Student stu) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.INSTANCE.openSession();
			session.update("cn.example.domain.StudentMapper.update", stu);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();			
		}
	}

	@Override
	public void delete(Long id) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.INSTANCE.openSession();
			session.delete("cn.example.domain.StudentMapper.delete", id);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();			
		}

	}

	@Override
	public Student queryOne(Long id) {
		Student stu = null;
		SqlSession session = null;
		try {
			session = MyBatisUtil.INSTANCE.openSession();
			stu = session.selectOne("cn.example.domain.StudentMapper.queryOne", id);
			return stu;
		} finally {
			session.close();			
		}
}

	@Override
	public List<Student> queryAll() {
		List<Student> stus = new ArrayList<Student>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.INSTANCE.openSession();
			stus = session.selectList("cn.example.domain.StudentMapper.queryAll");
			return stus;
		} finally {
			session.close();			
		}
	}

}
