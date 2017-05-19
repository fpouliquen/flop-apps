package fr.flop.songmanager.service.impl;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.flop.songmanager.service.ScoreImportingService;

/**
 *
 */
@Component
@Transactional(readOnly = true)
public class ScoreImportingServiceImpl implements ScoreImportingService {

	private static final Logger LOGGER = Logger.getLogger(ScoreImportingServiceImpl.class);

	/*
	 * *************************************************************************
	 * 
	 * *************************************************************************
	 */

	@Override
	@Transactional(readOnly = false)
	public void importScore(File scoreFile) {

	}
}
