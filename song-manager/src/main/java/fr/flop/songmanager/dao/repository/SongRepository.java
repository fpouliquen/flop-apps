package fr.flop.songmanager.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.flop.songmanager.dao.entity.Song;

public interface SongRepository extends JpaRepository<Song, Integer> {

	/**
	 * Retrieves the song associated with the given parameters.
	 * 
	 * @param title
	 *            The title of the wanted song.
	 * @param songWriterIds
	 *            The song writers associated with the wanted song.
	 * @return The song associated with the given parameters.
	 */
	Song findByTitleIgnoreCaseAndSongSongWritersSongWriterIdIn(String title, List<Integer> songWriterIds);
}
