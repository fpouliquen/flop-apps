
package org.flop.fsm.repository.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.flop.fsm.domain.Song;
import org.flop.fsm.repository.CustomSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.Assert;

import com.google.common.base.Strings;

public class SongRepositoryImpl implements CustomSongRepository {

	private final MongoOperations mongoOperations;

	@Autowired
	public SongRepositoryImpl(MongoOperations mongoOperations) {
		Assert.notNull(mongoOperations, "MongoOperations must not be null !");
		this.mongoOperations = mongoOperations;
	}

	@Override
	public List<Song> findByTitleAndAuthor(String title, String author) {
		Query query = new Query();
		boolean hasAtLeastOneCriteria = false;

		if (StringUtils.isNotEmpty(title)) {
			query.addCriteria(where("title").regex(getCaseInsensitiveAndUnicodeBasedPattern(title)));
			hasAtLeastOneCriteria = true;
		}

		if (StringUtils.isNotEmpty(author)) {
			query.addCriteria(where("author").regex(getCaseInsensitiveAndUnicodeBasedPattern(author)));
			hasAtLeastOneCriteria = true;
		}

		return hasAtLeastOneCriteria ? mongoOperations.find(query, Song.class) : mongoOperations.findAll(Song.class);
	}

	/**
	 * Returns a pattern for a case insensitive search based on a unicode char set.
	 * 
	 * @param regex The regex used by the returned pattern
	 * @return
	 */
	private Pattern getCaseInsensitiveAndUnicodeBasedPattern(String regex) {
		return Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
	}
}
