package swd20.musicstore;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.junit4.SpringRunner;

import swd20.musicstore.domain.Album;
import swd20.musicstore.domain.AlbumRepository;
import swd20.musicstore.domain.UserRepository;
import swd20.musicstore.domain.Users;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@RunWith(SpringRunner.class)
@DataJpaTest


public class AlbumRepositoryTest {

    @Autowired
    private AlbumRepository repository;

 
    
    @Test
    public void createNewAlbum() {
    	
    	Album album = new Album("Testi");
    	repository.save(album);
    	
    	assertThat(album.getAlbumId()).isNotNull();
    }    

    @Test
	public void deleteUser() {
  
    	Album album = new Album("Testi");
    	repository.save(album);

    	repository.deleteById(album.getAlbumId());
    	album = repository.findById(album.getAlbumId()).orElse(null);
    	
    	assertThat(album).isNull();
	}
	
}