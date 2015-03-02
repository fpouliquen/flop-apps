
package org.flop.fsm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

@Configuration
@EnableMongoRepositories(basePackages = "org.flop.fsm.repository")
public class MongoConfiguration extends AbstractMongoConfiguration {

	// mongodb config

	@Override
	protected String getDatabaseName() {
		return "fsmdb";
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
		return "org.flop.fsm.domain";
	}

	// mongo template

	@Override
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), getDatabaseName());
	}

}
