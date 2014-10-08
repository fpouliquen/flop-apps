
package org.flop.wtm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

@Configuration
@EnableMongoRepositories(basePackages = "org.flop.wtm.repository")
public class MongoConfiguration extends AbstractMongoConfiguration {

	// mongodb config

	@Override
	protected String getDatabaseName() {
		return "wtmdb";
	}

	@Override
	@Bean
	public MongoClient mongo() throws Exception {
		MongoClient client = new MongoClient("localhost");
		client.setWriteConcern(WriteConcern.SAFE);
		return client;
	}

	@Override
	protected String getMappingBasePackage() {
		return "org.flop.wtm.domain";
	}

	// mongo template

	@Override
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), getDatabaseName());
	}

}
