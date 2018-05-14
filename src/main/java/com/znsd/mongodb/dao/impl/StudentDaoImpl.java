package com.znsd.mongodb.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.znsd.mongodb.bean.StudentBean;
import com.znsd.mongodb.dao.IStudentDao;

@Repository
public class StudentDaoImpl implements IStudentDao{

	 	@Autowired
	    private MongoTemplate mongoTemplate;

	    /**
	     * 创建对象
	     * @param user
	     */
	    @Override
	    public void saveStudent(StudentBean student) {
	    	System.out.println(mongoTemplate);
	    	System.out.println(student);
	        mongoTemplate.save(student);
	    }

	    /**
	     * 根据用户名查询对象
	     * @param userName
	     * @return
	     */
	    @Override
	    public List<StudentBean> findUserByStudentName() {
	        //Query query=new Query(Criteria.where("StudentName").is(StudentName));
	        //StudentBean user =  mongoTemplate.findOne(query , StudentBean.class);
	        //查询所有关于这个表的数据
	        List<StudentBean> list=mongoTemplate.findAll(StudentBean.class, "student");
	        return list;
	    }

	    /**
	     * 更新对象
	     * @param user
	     */
	    @Override
	    public void updateStudent(StudentBean student) {
	        Query query=new Query(Criteria.where("studentName").is(student.getStudentName()));
	        Update update= new Update().set("studentName", student.getStudentName()).set("age", student.getAge());
	        //更新查询返回结果集的第一条
	        mongoTemplate.updateFirst(query,update,StudentBean.class);
	        //更新查询返回结果集的所有
	        // mongoTemplate.updateMulti(query,update,UserEntity.class);
	    }

	    /**
	     * 删除对象
	     * @param id
	     */
	    public void deleteUserById(String id) {
	        Query query=new Query(Criteria.where("_id").is(id));
	        mongoTemplate.remove(query,StudentBean.class);
	        //删除一个对象
	       // mongoTemplate.remove(student, "studentBean");
	    }
	    
	    public void deleteUser(StudentBean student) {
	    	//mongoTemplate.remove(student, "studentBean");
	    	
	    	//删除表
	    	mongoTemplate.dropCollection(StudentBean.class);
	    }
}
