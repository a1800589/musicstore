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
	private Long songId;
	@Column(name = "name", nullable = false)
	private String songName;
	@Column(name = "artist", nullable = false)
	private String songArtist;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "albumId")
	private Album album;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "artistId")
	private Artist artist;
	
	

	public Song() {
		super();
	}



	public Song(Long songId, String songName, String songArtist, Album album, Artist artist) {
		super();
		this.songId = songId;
		this.songName = songName;
		this.songArtist = songArtist;
		this.album = album;
		this.artist = artist;
	}



	public Long getSongId() {
		return songId;
	}



	public void setSongId(Long songId) {
		this.songId = songId;
	}



	public String getSongName() {
		return songName;
	}



	public void setSongName(String songName) {
		this.songName = songName;
	}



	public String getSongArtist() {
		return songArtist;
	}



	public void setSongArtist(String songArtist) {
		this.songArtist = songArtist;
	}



	public Album getAlbum() {
		return album;
	}



	public void setAlbum(Album album) {
		this.album = album;
	}



	public Artist getArtist() {
		return artist;
	}



	public void setArtist(Artist artist) {
		this.artist = artist;
	}



	@Override
	public String toString() {
		if (this.album != null)
			return "Song [songId=" + songId + ", songName=" + songName + ", album=" + this.getAlbum() + "]";
		else
			return "Song [songId=" + songId + ", songName=" + songName + "]";

	}

}
