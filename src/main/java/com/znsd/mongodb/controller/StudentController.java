package com.znsd.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.znsd.mongodb.bean.StudentBean;
import com.znsd.mongodb.service.IStudentService;

@RestController
public class StudentController {
	
	@Autowired
	private IStudentService studentService;
	
	@RequestMapping(value="/students",method=RequestMethod.POST)
	public void save() {
		 	StudentBean student=new StudentBean();
	       student.setStudentName("王八");
	       student.setAge(38);
	       studentService.save(student);
	       System.out.println("增加成功");
	}
	
	@RequestMapping(value="/students",method=RequestMethod.GET)
	public void query() {	 	
		List<StudentBean> list=  studentService.findUserByStudentName();
	       System.out.println(list);
	}
	
	@RequestMapping(value="/students",method=RequestMethod.PUT)
	public void update() {	 	
		StudentBean student=new StudentBean();
	       student.setStudentName("王八");
	       student.setAge(18);
	       studentService.updateStudent(student);
	}
	
	@RequestMapping(value="/students",method=RequestMethod.DELETE)
	public void delete() {	 	
			String id="5ad8ab58273e659ffc9a0fdf";
	       studentService.deleteUserById(id);
	}
	
	@RequestMapping(value="/student",method=RequestMethod.DELETE)
	public void deleteUser() {	 	
			StudentBean student=new StudentBean();
		       student.setStudentName("王八");
		       student.setAge(38);
	       studentService.deleteUser(student);
	}
	
}
