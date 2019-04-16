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

import swd20.musicstore.domain.Album;
import swd20.musicstore.domain.AlbumRepository;

import swd20.musicstore.domain.SongRepository;

@Controller
public class AlbumController {

	@Autowired
	private AlbumRepository aRepository;

	@Autowired
	private SongRepository sRepository;
	
	@GetMapping("/addAlbum")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String getNewAlbumForm(Model model) {
		//model.addAttribute("song", new Song());
		model.addAttribute("album", new Album());
		return "addAlbum";
	}

	@PostMapping("/addAlbum")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String saveAlbum(@ModelAttribute Album album) {

		aRepository.save(album);
		return "redirect:/songlist";
	}
	
	
	@GetMapping("/deletealbum/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteSong(@PathVariable("id") Long albumId) {

		aRepository.deleteById(albumId);
		return "redirect:../songlist";
	}
	
	@GetMapping("/editAlbum/{id}")

	public String editAlbum(@PathVariable("id") Long albumId, Model model) {

		model.addAttribute("albums", aRepository.findById(albumId).orElse(null));
		model.addAttribute("songs", sRepository.findAll());
		return "editAlbum";
	}

	@PostMapping("/editAlbum")

	public String editSaveAlbum(@ModelAttribute Album album) {

		aRepository.save(album);
		return "redirect:/songlist";
	}
	
	@RequestMapping(value = "/albums", method = RequestMethod.GET)
	public @ResponseBody List<Album> albumListRest() {
		return (List<Album>) aRepository.findAll();
	}

	@RequestMapping(value = "/album/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Album> findAlbumRest(@PathVariable("id") Long albumId) {
		return aRepository.findById(albumId);
	}
	
	
}
