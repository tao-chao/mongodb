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
		// ���ӵ� mongodb ����
	    MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	  
	    // ���ӵ����ݿ�
	    MongoDatabase database = mongoClient.getDatabase("ttt");
	   
	  System.out.println("Connect to database successfully");
	  System.out.println("MongoDatabase inof is : "+database.getName());
	  MongoCollection<Document> coll = database.getCollection("ttt");
	  
	  //��ѯ
	  coll.find().forEach(printBlock);
	  
	  
	  //����
	  //��������
	  Document document = new Document("name", "����").append("age", 15);
	  //coll.insertOne(document);
	  //�������  new����Document�Ž�list Ȼ��������
	  Document doc1 = new Document("�༶��", "1702")
              .append("����", new Document("name", "�ϴ�")
                                      .append("age", 38)
                                      .append("location",Arrays.asList(520, 1314)))
              .append("˧��", "�ճ�")
              .append("С��", Arrays.asList("�϶�", "����", "����"));
	  List<Document> documents = new ArrayList<Document>();
	  documents.add(doc1);
	 //coll.insertMany(documents);
	  
	  
	  //�޸�
	  //coll.updateOne(Filters.eq("name","����" ),new Document("$set", new Document("age", 16)));
	  
	  //ɾ��
	  //coll.deleteOne(Filters.eq("name","zhangsan4"));

	  
	}
	//��ѯ��ȡ����
	 static Block<Document> printBlock = new Block<Document>() {
	        public void apply(final Document document) {
	            System.out.println(document.toJson());
	        }
	    };
	    
}
