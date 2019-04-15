package swd20.musicstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import swd20.musicstore.domain.Artist;
import swd20.musicstore.domain.ArtistRepository;

@Controller
public class ArtistController {

	@Autowired
	private ArtistRepository aRepository;
	
	
	@GetMapping("/addArtist")
	public String getNewArtistForm(Model model) {
		
		model.addAttribute("artist", new Artist());
		return "addArtist";
	}

	@PostMapping("/addArtist")
	public String saveArtist(@ModelAttribute Artist artist) {

		aRepository.save(artist);
		return "redirect:/songlist";
	}
	
	
}
