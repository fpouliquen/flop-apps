
package org.flop.fsm.repository;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.flop.fsm.TestData;
import org.flop.fsm.configuration.MongoConfiguration;
import org.flop.fsm.domain.Song;
import org.flop.fsm.repository.SongRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = { MongoConfiguration.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class SongRepositoryTest {

	@Autowired
	private SongRepository songRepository;

	@Before
	public void reset() {
		TestData.songs();
	}

	@Test
	public void testFindByTitleAndAuthorCaseInsensitive() {
		List<Song> songs = songRepository.findByTitleAndAuthor("VéRité", "HUB");

		assertThat(songs, notNullValue());
		assertThat(songs.size(), equalTo(1));
		assertThat(songs.get(0).getTitle(), equalTo("Le chemin, la vérité, la vie"));
		assertThat(songs.get(0).getAuthor(), equalTo("SergeHub"));
	}

	@Test
	public void testFindByTitleAndAuthorMultipleResults() {
		List<Song> songs = songRepository.findByTitleAndAuthor(null, "StéphAnE QUéry");

		assertThat(songs, notNullValue());
		assertThat(songs.size(), equalTo(2));
	}

	@Test
	public void testFindByTitleAndAuthorNullValues() {
		List<Song> songs = songRepository.findByTitleAndAuthor(null, null);

		assertThat(songs, notNullValue());
		assertThat(songs.size(), equalTo(4));
	}
}
