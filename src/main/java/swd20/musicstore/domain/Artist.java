package swd20.musicstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "artistId", nullable = false, updatable = false)
	private Long artistId;
	@Column(name = "artistName", nullable = false)
	private String artistName;

	public Artist(Long artistId, String artistName, List<Song> songs) {
		super();
		this.artistId = artistId;
		this.artistName = artistName;
		this.songs = songs;
	}

	public Artist() {
		super();
	}

	public Long getArtistId() {
		return artistId;
	}

	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "artist")
	private List<Song> songs;

}
