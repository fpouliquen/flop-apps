package fr.flop.songmanager.dto;

import java.util.ArrayList;
import java.util.List;

public class SongDto {

	private Integer songId;

	private List<Integer> songWriterIds = new ArrayList<Integer>();

	private String title;

	/*
	 * *************************************************************************
	 * 
	 * *************************************************************************
	 */

	public Integer getSongId() {
		return songId;
	}

	public void setSongId(Integer songId) {
		this.songId = songId;
	}

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
