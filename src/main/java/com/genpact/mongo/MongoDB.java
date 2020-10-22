package com.genpact.mongo;

import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDB {

	public static void main(String[] args) {

		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

		MongoDatabase genpact = mongoClient.getDatabase("myDB");

		MongoCollection<Document> posts = genpact.getCollection("films");

//		Document post = posts.find(new Document("userId", 2)).first();
//		System.out.println(post.toJson());
		
		
		FindIterable<Document> post = posts.find();
		Iterator<Document> it = post.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toJson());
		}

	}

}
