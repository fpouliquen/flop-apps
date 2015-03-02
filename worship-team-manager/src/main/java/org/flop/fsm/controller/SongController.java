
package org.flop.fsm.controller;

import org.springframework.ui.Model;

public interface SongController {

	/**
	 * Displays the song page.
	 * 
	 * @return The displayed template.
	 */
	public String display();

	/**
	 * This method is used to perform a search on the songs using the given parameters.
	 * 
	 * @param title The title of the wanted songs.
	 * @param author The author of the wanted songs.
	 * @param model The model object used to transfer data.
	 * @return The retrieved songs.
	 */
	public String search(String title, String author, Model model);

}