package product.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import product.model.Music;
import product.repository.MusicRepository;

@Slf4j
@Controller
@RequestMapping("/display")
public class DisplayController {
	private final MusicRepository musicRepository;

	@Autowired
	public DisplayController(MusicRepository musicRepository) {
		this.musicRepository = musicRepository;
	}

	@ModelAttribute
	public void listProductsToModel(Model model) {
		List<Music> musics = new ArrayList<>();
		musicRepository.findAll().forEach(musics::add);
		model.addAttribute("music", musics);
	}

	@GetMapping
	public String show(Model model) {
		return "display";
	}

	@PostMapping
	public String add() {
		return "redirect:/add";
	}
	@PostMapping("/edit")
	public String edit() {
		return "redirect:/edit";
	}
	@PostMapping("/delete")
	public String delete() {
		return "redirect:/delete";
	}
}
