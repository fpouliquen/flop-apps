package fr.flop.songmanager.task.impl;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import fr.flop.songmanager.manager.DirectoryManager;
import fr.flop.songmanager.service.ScoreImportingService;
import fr.flop.songmanager.task.ServerTasks;
import fr.flop.songmanager.util.file.SpringProperties;
import fr.flop.songmanager.util.log.ELogFunction;
import fr.flop.songmanager.util.log.LogUtils;

/**
 * 
 */
@Component("serverTasks")
public class ServerTasksImpl implements ServerTasks {

	private static final Logger LOGGER = Logger.getLogger(ServerTasksImpl.class);

	@Autowired
	private ScoreImportingService scoreImportingService;

	@Autowired
	private DirectoryManager directoryManager;

	@Autowired
	private SpringProperties properties;

	/*
	 * *************************************************************************
	 * 
	 * *************************************************************************
	 */

	@Override
	@Scheduled(fixedDelay = 1000)
	public void scanScoreImportingDirectory() {
		try {
			File scoreImportingDirectory = directoryManager.getScoreImportingDirectory();

			for (File fileToImport : scoreImportingDirectory.listFiles((fileToFilter) -> fileToFilter.isFile())) {
				try {
					// scoreImportingTaskService.importerDeroule(file);

					// Moves the imported file into the storage
					// FileUtils.moveFromToFile(file, new
					// File(tatooineRepertoireManager.getRepertoireAccepte(),
					// TatooineServeurFileUtils.getNomFichierDerouleStockage(file,
					// version)));
				} catch (Exception e) {
					LOGGER.error(LogUtils.getLog(ELogFunction.SCORE_IMPORTING, "An error occured"), e);

					// if (file.exists()) {
					// FileUtils.moveFileToDirectory(file,
					// directoryManager.getScoreRejectedDirectory());
					// }
				}
			}
		} catch (Exception e) {
			LOGGER.error(LogUtils.getLog(ELogFunction.SCORE_IMPORTING, "An error occured while the score importing"),
					e);
		}
	}
}
