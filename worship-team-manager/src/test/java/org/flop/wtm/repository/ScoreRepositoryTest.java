
package org.flop.wtm.repository;

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
	public void testFindByTitleAndAuthorAndKey() {
		List<Score> scores = scoreRepository.findByTitleAndAuthorAndKey("vérité", null, null);

	}
}
