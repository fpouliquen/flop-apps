
package org.flop.wtm.controller;

import org.springframework.ui.Model;

public interface SearchController {

	/**
	 * This method is used to perform a search on the scores using the given parameters.
	 * 
	 * @param title The title of the wanted scores.
	 * @param author The author of the wanted scores.
	 * @param key The key of the wanted scores.
	 * @param model The model object used to transfer data.
	 * @return
	 */
	public abstract String search(String title, String author, String key, Model model);

}