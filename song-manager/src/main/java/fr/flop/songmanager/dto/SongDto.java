package fr.flop.songmanager.dto;

import java.util.ArrayList;
import java.util.List;

public class SongDto {

	private List<Integer> songWriterIds = new ArrayList<Integer>();

	private String title;

	/*
	 * *************************************************************************
	 * 
	 * *************************************************************************
	 */

	public List<Integer> getSongWriterIds() {
		return songWriterIds;
	}

	public void setSongWriterIds(List<Integer> songWriterIds) {
		this.songWriterIds = songWriterIds;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
