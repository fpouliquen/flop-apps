
package org.flop.wtm.service.impl;

import java.util.List;

import org.flop.wtm.domain.Score;
import org.flop.wtm.dto.ScoreDto;
import org.flop.wtm.repository.ScoreRepository;
import org.flop.wtm.service.MappingService;
import org.flop.wtm.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {

	private ScoreRepository scoreRepository;

	private MappingService mappingService;

	@Autowired
	public ScoreServiceImpl(ScoreRepository scoreRepository, MappingService mappingService) {
		this.scoreRepository = scoreRepository;
		this.mappingService = mappingService;
	}

	@Override
	public List<ScoreDto> search(String title, String author, String key) {
		List<Score> retrievedScores = scoreRepository.findByTitleAndAuthorAndKey(title, author, key);
		return mappingService.map(retrievedScores, ScoreDto.class);
	}
}
