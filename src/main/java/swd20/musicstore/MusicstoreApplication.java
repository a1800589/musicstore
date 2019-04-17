package swd20.musicstore;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


import swd20.musicstore.domain.Song;
import swd20.musicstore.domain.SongRepository;

import swd20.musicstore.domain.AlbumRepository;

import swd20.musicstore.domain.UserRepository;
import swd20.musicstore.domain.Users;

@SpringBootApplication
@EnableJpaAuditing
public class MusicstoreApplication  {

	private static final Logger log = LoggerFactory.getLogger(MusicstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MusicstoreApplication.class, args);
	}
   

	@Bean
	public CommandLineRunner musicDemo(SongRepository songRepository, AlbumRepository aRepository,
			UserRepository uRepository) {
		return (args) -> {
			 

			log.info("fetch all songs");
			for (Song song : songRepository.findAll()) {
				log.info(song.toString());
			}

		};
	}
}
