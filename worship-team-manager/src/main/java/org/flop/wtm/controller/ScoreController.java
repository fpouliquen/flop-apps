
package org.flop.wtm.controller;

import org.springframework.ui.Model;

public interface ScoreController {

	/**
	 * Displays the score page.
	 * 
	 * @return The displayed template.
	 */
	public String display();

	/**
	 * This method is used to perform a search on the scores using the given parameters.
	 * 
	 * @param title The title of the wanted scores.
	 * @param author The author of the wanted scores.
	 * @param key The key of the wanted scores.
	 * @param model The model object used to transfer data.
	 * @return The retrieved scores.
	 */
	public String search(String title, String author, String key, Model model);

}