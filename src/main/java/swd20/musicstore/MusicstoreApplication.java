package swd20.musicstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import swd20.musicstore.domain.Song;
import swd20.musicstore.domain.SongRepository;
import swd20.musicstore.domain.Album;
import swd20.musicstore.domain.AlbumRepository;
import swd20.musicstore.domain.Users;
import swd20.musicstore.domain.UserRepository;

@SpringBootApplication
@EnableJpaAuditing
public class MusicstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(MusicstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MusicstoreApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner musicDemo(SongRepository songRepository1, AlbumRepository aRepository,
			UserRepository uRepository) {
		return (args) -> {
		
			// aRepository.save(new Album("Eepos"));
			// aRepository.save(new Album("Komedia"));
			// aRepository.save(new Album("Muu"));

			// songRepository1.save(new Song(null, "Kalevala", "Makkonen Sami", 2019,
			// "9789511335696", 21.95, cRepository.findByName("Eepos").get(0)));
			// songRepository1.save(new Song(null, "Fingerpori 12", "Jarla Pertti", 2019,
			// "9789520118990", 17.95, cRepository.findByName("Komedia").get(0)));

			
			Users user1 = new Users("admin", "$2a$10$kK6wHneFME4Mo3Ar9H.NXu/x09MAK6M0C8Zvcxutx/j3YJ7SNM5.y", "ADMIN");
			uRepository.save(user1);
			

			log.info("fetch all songs");
			for (Song song : songRepository1.findAll()) {
				log.info(song.toString());
			}
		};
	}*/
}
