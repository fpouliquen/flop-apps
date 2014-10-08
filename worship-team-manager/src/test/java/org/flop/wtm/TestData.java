
package org.flop.wtm;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class TestData {

	public static void scores() {
		MongoClient client = mongoClient();
		DB db = client.getDB("wtmdb");

		DBCollection scores = db.getCollection("scores");
		scores.drop();

		scores.insert(dbObjectFromJson("{_id : 1, title : 'Le chemin, la vérité, la vie', author : 'SergeHub', key : ''}"));
	}

	private static MongoClient mongoClient() {
		try {
			return new MongoClient("localhost", 27017);
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
	}

	private static DBObject dbObjectFromJson(String json) {
		return (DBObject) JSON.parse(json);
	}
}
