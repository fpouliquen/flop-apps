
package org.flop.wtm.repository;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.flop.wtm.TestData;
import org.flop.wtm.configuration.MongoConfiguration;
import org.flop.wtm.domain.Score;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = { MongoConfiguration.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class ScoreRepositoryTest {

	@Autowired
	private ScoreRepository scoreRepository;

	@Before
	public void reset() {
		TestData.scores();
	}

	@Test
	public void testFindByTitleAndAuthorAndKeyCaseInsensitive() {
		List<Score> scores = scoreRepository.findByTitleAndAuthorAndKey("VéRité", "HUB", null);

		assertThat(scores, notNullValue());
		assertThat(scores.size(), equalTo(1));
		assertThat(scores.get(0).getTitle(), equalTo("Le chemin, la vérité, la vie"));
		assertThat(scores.get(0).getAuthor(), equalTo("SergeHub"));
	}

	@Test
	public void testFindByTitleAndAuthorAndKeyMultipleResults() {
		List<Score> scores = scoreRepository.findByTitleAndAuthorAndKey(null, "StéphAnE QUéry", null);

		assertThat(scores, notNullValue());
		assertThat(scores.size(), equalTo(2));
	}

	@Test
	public void testFindByTitleAndAuthorAndKeyNullValues() {
		List<Score> scores = scoreRepository.findByTitleAndAuthorAndKey(null, null, null);

		assertThat(scores, notNullValue());
		assertThat(scores.size(), equalTo(4));
	}
}
