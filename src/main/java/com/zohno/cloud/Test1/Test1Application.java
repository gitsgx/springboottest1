package com.zohno.cloud.Test1;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Test1Application {

	@RequestMapping("/")
	public String home() {
		Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
		// The kind for the new entity
		String kind = "Task";
		// The name/ID for the new entity
		String name = "sampletask1";
		// The Cloud Datastore key for the new entity
		Key taskKey = datastore.newKeyFactory().setKind(kind).newKey(name);

//		// Prepares the new entity
//		Entity task = Entity.newBuilder(taskKey).set("description", "Buy milk").build();
//
//		// Saves the entity
//		datastore.put(task);

//		String res = String.format( "Saved %s: %s%n", task.getKey().getName(), task.getString("description") );

		// Retrieve entity
		Entity retrieved = datastore.get(taskKey);

		String res = String.format("Retrieved %s: %s%n", taskKey.getName(), retrieved.getString("description"));

		return res;
	}

	public static void main(String[] args) {
		SpringApplication.run(Test1Application.class, args);
	}

}
