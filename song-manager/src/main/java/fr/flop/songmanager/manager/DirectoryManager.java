package fr.flop.songmanager.manager;

import java.io.File;

public interface DirectoryManager {

	/**
	 * @return The scores to import are moved here.
	 */
	File getScoreImportingDirectory();

	/**
	 * @return The rejected scores are moved here.
	 */
	File getScoreRejectedDirectory();

	/**
	 * @return The scores are stored here.
	 */
	File getScoreStorageDirectory();
}
