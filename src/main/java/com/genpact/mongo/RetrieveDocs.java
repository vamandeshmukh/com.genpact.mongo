package com.genpact.mongo;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class RetrieveDocs {

	public static void main(String[] args) {

		// connect to mongodb 
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase genpact = mongoClient.getDatabase("genpact");
		MongoCollection<Document> posts = genpact.getCollection("posts");

//		 retrieve one document 
		Document post = posts.find(new Document("userId", 2)).first();
		System.out.println(post.toJson());

//		 retrieve all documents 
		FindIterable<Document> post2 = posts.find();
		Iterator<Document> it = post2.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toJson());
		}

//      retrieve all documents into a List object 
		List<Document> postList = posts.find().into(new ArrayList<>());
		for (Document post3 : postList) {
			System.out.println(post3.toJson());
		}
		mongoClient.close();

	}

}
