package fr.flop.songmanager.service;

import java.io.File;

public interface ScoreImportingService {

	/**
	 * Import the given score file.
	 * 
	 * @param scoreFile
	 *            The score file to import.
	 */
	void importScore(File scoreFile);

}
