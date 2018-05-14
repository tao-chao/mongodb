package com.znsd.mongodb;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MyTest {

	public static void main(String[] args) {
		// 连接到 mongodb 服务
	    MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	  
	    // 连接到数据库
	    MongoDatabase database = mongoClient.getDatabase("ttt");
	   
	  System.out.println("Connect to database successfully");
	  System.out.println("MongoDatabase inof is : "+database.getName());
	  MongoCollection<Document> coll = database.getCollection("ttt");
	  
	  //查询
	  coll.find().forEach(printBlock);
	  
	  
	  //增加
	  //单个增加
	  Document document = new Document("name", "张三").append("age", 15);
	  //coll.insertOne(document);
	  //多个增加  new几个Document放进list 然后再增加
	  Document doc1 = new Document("班级号", "1702")
              .append("四组", new Document("name", "老大")
                                      .append("age", 38)
                                      .append("location",Arrays.asList(520, 1314)))
              .append("帅哥", "陶超")
              .append("小弟", Arrays.asList("老二", "老三", "老四"));
	  List<Document> documents = new ArrayList<Document>();
	  documents.add(doc1);
	 //coll.insertMany(documents);
	  
	  
	  //修改
	  //coll.updateOne(Filters.eq("name","张三" ),new Document("$set", new Document("age", 16)));
	  
	  //删除
	  //coll.deleteOne(Filters.eq("name","zhangsan4"));

	  
	}
	//查询拿取数据
	 static Block<Document> printBlock = new Block<Document>() {
	        public void apply(final Document document) {
	            System.out.println(document.toJson());
	        }
	    };
	    
}
