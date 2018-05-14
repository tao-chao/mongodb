package com.znsd.mongodb.service;

import java.util.List;

import com.znsd.mongodb.bean.StudentBean;

public interface IStudentService {

	public void save(StudentBean student);
	public List<StudentBean> findUserByStudentName();
	public void updateStudent(StudentBean student);
	void  deleteUserById(String id);
	void deleteUser(StudentBean student);
}
