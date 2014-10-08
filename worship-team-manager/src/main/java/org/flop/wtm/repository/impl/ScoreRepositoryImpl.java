
package org.flop.wtm.repository.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import org.flop.wtm.domain.Score;
import org.flop.wtm.repository.CustomScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.Assert;

import com.google.common.base.Strings;

public class ScoreRepositoryImpl implements CustomScoreRepository {

	private final MongoOperations mongoOperations;

	@Autowired
	public ScoreRepositoryImpl(MongoOperations mongoOperations) {
		Assert.notNull(mongoOperations, "MongoOperations must not be null !");
		this.mongoOperations = mongoOperations;
	}

	@Override
	public List<Score> findByTitleAndAuthorAndKey(String title, String author, String key) {
		Query query = new Query();
		boolean hasAtLeastOneCriteria = false;

		if (!Strings.isNullOrEmpty(title)) {
			query.addCriteria(where("title").is(title));
			hasAtLeastOneCriteria = true;
		}

		if (!Strings.isNullOrEmpty(author)) {
			query.addCriteria(where("author").is(author));
			hasAtLeastOneCriteria = true;
		}

		if (!Strings.isNullOrEmpty(key)) {
			query.addCriteria(where("key").is(key));
			hasAtLeastOneCriteria = true;
		}

		return hasAtLeastOneCriteria ? mongoOperations.find(query, Score.class) : mongoOperations.findAll(Score.class);
	}

}
