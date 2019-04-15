package swd20.musicstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import swd20.musicstore.domain.AlbumRepository;
import swd20.musicstore.domain.ArtistRepository;
import swd20.musicstore.domain.Song;
import swd20.musicstore.domain.SongRepository;

@Controller
public class SongController {
 
	@Autowired
	private AlbumRepository aRepository;

	@Autowired
	private SongRepository sRepository;
	
	

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@GetMapping("/songlist")
	public String getSongs(Model model) {
		List<Song> songs = (List<Song>) sRepository.findAll();
		model.addAttribute("songs", songs);
		return "songlist";
	} 
 
	@GetMapping("/artistList/{id}")
	public String getSongsForArtist(@PathVariable("id") Long songId, Model model) {
		List<Song> songs = (List<Song>) sRepository.findAll();
		model.addAttribute("songs", songs);
		return "artistList";
	} 
	
	@GetMapping("/addSong")
	public String getNewSongForm(Model model) {
		model.addAttribute("song", new Song());
		model.addAttribute("albums", aRepository.findAll());
		return "addSong";
	}
	
	

	@PostMapping("/addSong")
	public String saveSong(@ModelAttribute Song song) {

		sRepository.save(song);
		return "redirect:/songlist";
	}

	@GetMapping("/deletesong/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteSong(@PathVariable("id") Long songId) {

		sRepository.deleteById(songId);
		return "redirect:../songlist";
	}

	@GetMapping("/editSong/{id}")
	public String editSong(@PathVariable("id") Long songId, Model model) {

		model.addAttribute("song", sRepository.findById(songId));
		model.addAttribute("albums", aRepository.findAll());
		return "editSong";
	}

	@PostMapping("/editSong")
	public String editSaveSong(@ModelAttribute Song song) {

		sRepository.save(song);
		return "redirect:/songlist";
	}

	@RequestMapping(value = "/songs", method = RequestMethod.GET)
	public @ResponseBody List<Song> songListRest() {
		return (List<Song>) sRepository.findAll();
	}

	@RequestMapping(value = "/song/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Song> findSongRest(@PathVariable("id") Long songId) {
		return sRepository.findById(songId);
	}

}
