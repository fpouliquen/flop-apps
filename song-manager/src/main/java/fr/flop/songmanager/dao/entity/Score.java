package fr.flop.songmanager.dao.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;

/**
 * This class represents a given score file associated to a song.
 */
@Entity
@Table(name = "score")
public class Score {

	/**
	 * Generated id.
	 */
	@Id
	@SequenceGenerator(name = "score_seq", sequenceName = "score_seq", allocationSize = 1)
	@GeneratedValue(generator = "score_seq")
	@Column(name = "score_id")
	private Integer id;

	/**
	 * Each score is associated to one song.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "song_id")
	private Song song;

	/**
	 * The version of the received score file.
	 */
	@Column(name = "version", nullable = false)
	private Integer version;

	/**
	 * The date of receipt.
	 */
	@Column(name = "receipt_date", nullable = false)
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime receiptDate;

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
		Score other = (Score) obj;
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

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public LocalDateTime getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(LocalDateTime receiptDate) {
		this.receiptDate = receiptDate;
	}
}
