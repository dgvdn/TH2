package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import product.model.Music;
import product.repository.MusicRepository;

@Slf4j
@Controller
@RequestMapping("/add")
public class AddController {
	@GetMapping
	public String add(Model model) {
		model.addAttribute("music", new Music());
		return "add";
	}

	private final MusicRepository musicRepository;

	@Autowired
	public AddController(MusicRepository musicRepository) {
		this.musicRepository = musicRepository;
	}

	@PostMapping
	public String saveProduct(@ModelAttribute("music") Music music) {
		try {
			musicRepository.save(music);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/display/";
	}

	@PostMapping("/view")
	public String view() {
		return "redirect:/display/";
	}

}
