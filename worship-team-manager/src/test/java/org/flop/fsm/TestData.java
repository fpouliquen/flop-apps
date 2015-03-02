
package org.flop.fsm;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class TestData {

	public static void songs() {
		MongoClient client = mongoClient();
		DB db = client.getDB("fsmdb");

		DBCollection songs = db.getCollection("songs");
		songs.drop();

		songs.insert(dbObjectFromJson("{_id : 1, title : 'Le chemin, la vérité, la vie', author : 'SergeHub', key : ''}"));
		songs.insert(dbObjectFromJson("{_id : 2, title : 'A la croix', author : '', key : ''}"));
		songs.insert(dbObjectFromJson("{_id : 3, title : 'Remplis-moi de ta présence', author : 'Stéphane Quéry', key : ''}"));
		songs.insert(dbObjectFromJson("{_id : 4, title : 'A la rivière', author : 'Stéphane Quéry', key : ''}"));
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
