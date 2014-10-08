
package org.flop.wtm.service.impl;

import java.util.List;

import org.flop.wtm.domain.Score;
import org.flop.wtm.repository.ScoreRepository;
import org.flop.wtm.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements ISearchService {

	private ScoreRepository scoreRepository;

	@Autowired
	public SearchServiceImpl(ScoreRepository scoreRepository) {
		this.scoreRepository = scoreRepository;
	}

	@Override
	public List<Score> search(String title, String author, String key) {
		return scoreRepository.findByTitleAndAuthorAndKey(title, author, key);
	}
}
