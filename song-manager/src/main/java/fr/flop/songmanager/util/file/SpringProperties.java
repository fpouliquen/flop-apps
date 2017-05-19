package fr.flop.songmanager.util.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringProperties {

	@Value("${song.manager.importing.directory.path}")
	private String scoreImportingDirectoryPath;

	@Value("${song.manager.rejected.directory.path}")
	private String scoreRejectedDirectoryPath;

	@Value("${song.manager.storage.directory.path}")
	private String scoreStorageDirectoryPath;

	/*
	 * *************************************************************************
	 * 
	 * *************************************************************************
	 */

	public String getScoreImportingDirectoryPath() {
		return scoreImportingDirectoryPath;
	}

	public String getScoreRejectedDirectoryPath() {
		return scoreRejectedDirectoryPath;
	}

	public String getScoreStorageDirectoryPath() {
		return scoreStorageDirectoryPath;
	}
}
