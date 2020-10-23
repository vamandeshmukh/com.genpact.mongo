package com.genpact.mongo;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;

public class DeleteDocs {

	public static void main(String[] args) {

		System.out.println("connect to mongodb");
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase genpact = mongoClient.getDatabase("genpact");
		MongoCollection<Document> posts = genpact.getCollection("posts");

		System.out.println("Start");

		// delete one document
		Bson filter = eq("userId", 78846548);
		DeleteResult result = posts.deleteOne(filter);
		System.out.println(result);

		// formatting result 
		filter = eq("userId", -86587);
		Document doc = posts.findOneAndDelete(filter);
		System.out.println(doc.toJson(JsonWriterSettings.builder().indent(true).build()));

		// delete many documents
		filter = gte("userId", 4578544);
		result = posts.deleteMany(filter);
		System.out.println(result);

//		 drop the entire collection
//		MongoCollection<Document> del = genpact.getCollection("deleteC");
//		del.drop();

		System.out.println("End");

	}

}
