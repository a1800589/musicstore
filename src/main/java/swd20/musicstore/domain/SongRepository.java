package swd20.musicstore.domain;


import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {
	Song findBySongName(String songName);
}
