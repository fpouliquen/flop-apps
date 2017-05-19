package fr.flop.songmanager.dto;

public class SongWriterDto {

	private Integer songWriterId;

	private String firstName;

	private String lastName;

	/*
	 * *************************************************************************
	 * 
	 * *************************************************************************
	 */

	public Integer getSongWriterId() {
		return songWriterId;
	}

	public void setSongWriterId(Integer songWriterId) {
		this.songWriterId = songWriterId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
