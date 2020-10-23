package com.genpact.mongo;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;


public class UpdateDocs {

	public static void main(String[] args) {

		System.out.println("connect to mongodb");
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase genpact = mongoClient.getDatabase("genpact");
		MongoCollection<Document> posts = genpact.getCollection("posts");
		UpdateDocs.updateOneDoc(posts, 15);
		UpdateDocs.updateManyDocs(posts, 14);
		
	}

	// update one document
	public static UpdateResult updateOneDoc(MongoCollection<Document> posts, int userId) {
		Bson filter = eq("userId", userId);
		Bson updateOperation = set("title", "another title eeeeeeeeeeeeeee");
		UpdateResult updateResult = posts.updateOne(filter, updateOperation);
		System.out.println(updateResult);
		return updateResult;
	}

	// update many docs
	private static UpdateResult updateManyDocs(MongoCollection<Document> posts, int userId) {
		Bson filter = eq("userId", userId);
		Bson updateOperation = set("title", "another title aaaaaaaaaaaaa");
		UpdateResult updateResult = posts.updateMany(filter, updateOperation);
		System.out.println(updateResult);
		return updateResult;
	}

}
