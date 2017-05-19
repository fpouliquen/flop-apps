package fr.flop.songmanager.dao.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The association table between song and song writer.
 */
@Entity
@Table(name = "song_song_writer")
public class SongSongWriter {

	@EmbeddedId
	private SongSongWriterId id = new SongSongWriterId();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "song_id", nullable = false, insertable = false, updatable = false)
	private Song song;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "song_writer_id", nullable = false, insertable = false, updatable = false)
	private SongWriter songWriter;

	/*
	 * *************************************************************************
	 * 
	 * *************************************************************************
	 */

	public SongSongWriter() {
	}

	public SongSongWriter(Song song, SongWriter songWriter) {
		this();

		getId().setSongId(song.getId());
		getId().setSongWriterId(songWriter.getId());
		setSong(song);
		setSongWriter(songWriter);

		song.getSongSongWriters().add(this);
		songWriter.getSongSongWriters().add(this);
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
		SongSongWriter other = (SongSongWriter) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	public SongSongWriterId getId() {
		return id;
	}

	public void setId(SongSongWriterId id) {
		this.id = id;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public SongWriter getSongWriter() {
		return songWriter;
	}

	public void setSongWriter(SongWriter songWriter) {
		this.songWriter = songWriter;
	}
}
