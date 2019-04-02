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
import swd20.musicstore.domain.Song;
import swd20.musicstore.domain.SongRepository;

@Controller
public class SongController {

	@Autowired
	AlbumRepository aRepository;

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
	/*
	 * @GetMapping("/addBook") public String getNewBookForm(Model model) {
	 * model.addAttribute("book", new Book()); model.addAttribute("categories",
	 * cRepository.findAll()); return "addBook"; }
	 * 
	 * @PostMapping("/addBook") public String saveBook(@ModelAttribute Book book) {
	 * 
	 * bookRepository.save(book); return "redirect:/booklist"; }
	 * 
	 * @GetMapping("/deletebook/{id}")
	 * 
	 * @PreAuthorize("hasAuthority('ADMIN')") public String
	 * deleteBook(@PathVariable("id") Long bookId) {
	 * 
	 * bookRepository.deleteById(bookId); return "redirect:../booklist"; }
	 * 
	 * @GetMapping("/editBook/{id}") public String editBook(@PathVariable("id") Long
	 * bookId, Model model) {
	 * 
	 * model.addAttribute("book", bookRepository.findById(bookId));
	 * model.addAttribute("categories", cRepository.findAll()); return "editBook"; }
	 * 
	 * @PostMapping("/editBook") public String editSaveBook(@ModelAttribute Book
	 * book) {
	 * 
	 * bookRepository.save(book); return "redirect:/booklist"; }
	 * 
	 * @RequestMapping(value="/books", method = RequestMethod.GET)
	 * public @ResponseBody List<Book> bookListRest() { return (List<Book>)
	 * bookRepository.findAll(); }
	 * 
	 * @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	 * public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long
	 * bookId) { return bookRepository.findById(bookId); }
	 */

}
