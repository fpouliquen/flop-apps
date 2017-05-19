package fr.flop.songmanager.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SongSongWriterId implements Serializable {

	private static final long serialVersionUID = -3803624913507881194L;

	@Column(name = "song_id", unique = true, nullable = false)
	private Integer songId;

	@Column(name = "song_writer_id", unique = true, nullable = false)
	private Integer songWriterId;

	/*
	 * *************************************************************************
	 * 
	 * *************************************************************************
	 */

	public SongSongWriterId() {
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
		result = prime * result + ((songId == null) ? 0 : songId.hashCode());
		result = prime * result + ((songWriterId == null) ? 0 : songWriterId.hashCode());
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
		SongSongWriterId other = (SongSongWriterId) obj;
		if (songId == null) {
			if (other.songId != null) {
				return false;
			}
		} else if (!songId.equals(other.songId)) {
			return false;
		}
		if (songWriterId == null) {
			if (other.songWriterId != null) {
				return false;
			}
		} else if (!songWriterId.equals(other.songWriterId)) {
			return false;
		}
		return true;
	}

	public Integer getSongId() {
		return songId;
	}

	public void setSongId(Integer songId) {
		this.songId = songId;
	}

	public Integer getSongWriterId() {
		return songWriterId;
	}

	public void setSongWriterId(Integer songWriterId) {
		this.songWriterId = songWriterId;
	}
}
