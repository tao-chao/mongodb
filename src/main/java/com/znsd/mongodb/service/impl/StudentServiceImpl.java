package com.znsd.mongodb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.mongodb.bean.StudentBean;
import com.znsd.mongodb.dao.IStudentDao;
import com.znsd.mongodb.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private IStudentDao studentDao;
	
	public void save(StudentBean student) {
		studentDao.saveStudent(student);
	}
	
	public List<StudentBean> findUserByStudentName() {
		return studentDao.findUserByStudentName();
	}
	
	public void updateStudent(StudentBean student) {
		studentDao.updateStudent(student);
	}
	
	public void  deleteUserById(String id) {
		studentDao.deleteUserById(id);
	}
	
	public void deleteUser(StudentBean student) {
		studentDao.deleteUser(student);
	}
}
