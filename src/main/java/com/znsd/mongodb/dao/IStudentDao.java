package com.znsd.mongodb.dao;

import java.util.List;

import com.znsd.mongodb.bean.StudentBean;

public interface IStudentDao {

	void saveStudent(StudentBean student);

	List<StudentBean> findUserByStudentName();

	void updateStudent(StudentBean student);
	
	void deleteUserById(String id);
	
	void deleteUser(StudentBean student);

}
