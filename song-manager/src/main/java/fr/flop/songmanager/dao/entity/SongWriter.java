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
@Table(name = "song_writer")
public class SongWriter {

	/**
	 * Generated id.
	 */
	@Id
	@SequenceGenerator(name = "song_writer_seq", sequenceName = "song_writer_seq", allocationSize = 1)
	@GeneratedValue(generator = "song_writer_seq")
	@Column(name = "song_writer_id")
	private Integer id;

	@Column(name = "first_name", length = 32, nullable = false)
	private String firstName;

	@Column(name = "last_name", length = 32)
	private String lastName;

	/**
	 * A song writer can writes several songs.
	 */
	@OneToMany(mappedBy = "songWriter", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SongSongWriter> songSongWriters = new ArrayList<SongSongWriter>();

	/*
	 * *************************************************************************
	 * 
	 * *************************************************************************
	 */

	public SongWriter() {
	}

	public SongWriter(String firstName, String lastName) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
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
		SongWriter other = (SongWriter) obj;
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

	public List<SongSongWriter> getSongSongWriters() {
		return songSongWriters;
	}

	public void setSongSongWriters(List<SongSongWriter> songSongWriters) {
		this.songSongWriters = songSongWriters;
	}
}
