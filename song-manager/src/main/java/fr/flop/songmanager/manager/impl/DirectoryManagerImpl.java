package fr.flop.songmanager.manager.impl;

import java.io.File;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.flop.songmanager.manager.DirectoryManager;
import fr.flop.songmanager.util.exception.ServerException;
import fr.flop.songmanager.util.file.SpringProperties;
import fr.flop.songmanager.util.log.ELogFunction;
import fr.flop.songmanager.util.log.LogUtils;

/**
 *
 */
@Component
public class DirectoryManagerImpl implements DirectoryManager {

	@Autowired
	protected SpringProperties properties;

	/**
	 * Score files are imported here.
	 */
	private File scoreImportingDirectory;

	/**
	 * All rejected score files are stored here.
	 */
	private File scoreRejectedDirectory;

	/**
	 * Score files are stored here.
	 */
	private File scoreStorageDirectory;

	/*
	 * *************************************************************************
	 * 
	 * *************************************************************************
	 */

	/**
	 * Application directories initialization.
	 */
	@PostConstruct
	protected void init() {
		scoreImportingDirectory = initializeDirectory(properties.getScoreImportingDirectoryPath());
		scoreRejectedDirectory = initializeDirectory(properties.getScoreRejectedDirectoryPath());
		scoreStorageDirectory = initializeDirectory(properties.getScoreStorageDirectoryPath());
	}

	protected File initializeDirectory(String directoryName) {
		File directory = new File(directoryName);

		if (!directory.exists()) {
			throw new ServerException(LogUtils.getLog(ELogFunction.INIT,
					String.format("The following directory does not exists : %s ", directoryName)));
		}

		return directory;
	}

	/*
	 * *************************************************************************
	 * 
	 * *************************************************************************
	 */

	@Override
	public File getScoreImportingDirectory() {
		return scoreImportingDirectory;
	}

	@Override
	public File getScoreRejectedDirectory() {
		return scoreRejectedDirectory;
	}

	@Override
	public File getScoreStorageDirectory() {
		return scoreStorageDirectory;
	}
}
