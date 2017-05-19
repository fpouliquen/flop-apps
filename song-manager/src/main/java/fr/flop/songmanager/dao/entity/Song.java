package fr.flop.songmanager.dao.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "song")
public class Song {

	/**
	 * Generated id.
	 */
	@Id
	@SequenceGenerator(name = "song_seq", sequenceName = "song_seq", allocationSize = 1)
	@GeneratedValue(generator = "song_seq")
	@Column(name = "song_id")
	private Integer id;

	@Column(name = "title", length = 64, nullable = false)
	private String title;

	/**
	 * One song can be written by several song writers.
	 */
	@OneToMany(mappedBy = "song", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SongSongWriter> songSongWriters = new ArrayList<SongSongWriter>();

	/*
	 * *************************************************************************
	 * 
	 * *************************************************************************
	 */

	public Song() {
	}

	public Song(String title, List<SongWriter> songWriters) {
		this();
		this.title = title;

		if (songWriters != null) {
			// Creates the links between the song and its song writer(s)
			songWriters.forEach(songWriter -> new SongSongWriter(this, songWriter));
		}
	}

	/*
	 * *************************************************************************
	 * 
	 * *************************************************************************
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Song other = (Song) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<SongSongWriter> getSongSongWriters() {
		return songSongWriters;
	}

	public void setSongSongWriters(List<SongSongWriter> songSongWriters) {
		this.songSongWriters = songSongWriters;
	}
}
