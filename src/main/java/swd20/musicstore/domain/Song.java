package swd20.musicstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Song {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	long songId;
	@Column(name = "name", nullable = false)
	String songName;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "albumId")
	private Album album;

	public Song() {
		super();
	}

	public Song(long songId, String songName, Album album) {
		super();
		this.songId = songId;
		this.songName = songName;
		this.album = album;
	}

	public long getSongId() {
		return songId;
	}

	public String getSongName() {
		return songName;
	}

	public Album getAlbum() {
		return album;
	}
	@Override
	public String toString() {
		return "Song [songId=" + songId + ", songName=" + songName + ", album=" + album + "]";
	}

}
