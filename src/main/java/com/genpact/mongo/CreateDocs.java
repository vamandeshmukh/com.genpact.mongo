package com.genpact.mongo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class CreateDocs {

	private static Random random = new Random();

	public static void main(String[] args) {

		// connect to mongodb
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase genpact = mongoClient.getDatabase("genpact");
		MongoCollection<Document> posts = genpact.getCollection("posts");

		System.out.println("Start");
		// add one
		CreateDocs.insertOneDoc(posts);
		// add many
//		CreateDocs.insertManyDocs(posts, 50);
		System.out.println("End");
	}

	private static void insertOneDoc(MongoCollection<Document> posts) {
		posts.insertOne(CreateDocs.createPost());
	}

	private static void insertManyDocs(MongoCollection<Document> posts, int numberOfPosts) {
		List<Document> postList = new ArrayList<>();
		for (int i = 1; i <= numberOfPosts; i++) {
			postList.add(CreateDocs.createPost());
		}
		posts.insertMany(postList);
	}

	private static Document createPost() {
		int temp = random.nextInt(100), temp2 = temp * 10;
		String temp3 = "post" + Integer.toString(temp), temp4 = temp3 + Integer.toString(temp2);
		System.out.println("Enter");
		Scanner sc = new Scanner(System.in);
		Document doc2 = new Document("id", sc.nextInt()).append("name", sc.next()).append("salary", sc.nextDouble());
		
//		Document doc = new Document("userId", temp).append("id", temp2).append("title", temp3).append("body", temp4);
		
		return doc2;
	}
}
