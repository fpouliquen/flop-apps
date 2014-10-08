
package org.flop.wtm.service;

import java.util.List;

import org.flop.wtm.domain.Score;

public interface ISearchService {

	public abstract List<Score> search(String title, String author, String key);

}