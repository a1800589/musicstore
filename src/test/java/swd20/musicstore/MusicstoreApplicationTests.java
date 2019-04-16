package swd20.musicstore;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import swd20.musicstore.web.AlbumController;
import swd20.musicstore.web.SongController;
import swd20.musicstore.web.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicstoreApplicationTests {


	@Autowired
	private SongController songController;
	
	@Autowired
	private AlbumController albumController;
	
	@Autowired
	private UserController userController;
	
	
	@Test
	public void contextLoads() {
	
		assertThat(songController).isNotNull();
		assertThat(albumController).isNotNull();
		assertThat(userController).isNotNull();
	
	
	}
	
	
	

}
