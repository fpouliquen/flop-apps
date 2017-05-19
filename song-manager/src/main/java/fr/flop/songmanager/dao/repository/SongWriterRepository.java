package fr.flop.songmanager.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.flop.songmanager.dao.entity.SongWriter;

public interface SongWriterRepository extends JpaRepository<SongWriter, Integer> {

	/**
	 * Returns the song writer associated with the given parameters if any.
	 * 
	 * @param firstName
	 *            The first name of the wanted song writer.
	 * @param lastName
	 *            The last name of the wanted song writer.
	 * @return The song writer associated with the given parameters if any.
	 */
	SongWriter findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);

	/**
	 * Retrieves the song writer(s) associated with the given parameters if any.
	 * 
	 * @param songWriterIds
	 *            The id(s) of the wanted song writer(s)
	 * @return The song writers associated with the given parameters.
	 */
	List<SongWriter> findByIdIn(List<Integer> songWriterIds);
}
