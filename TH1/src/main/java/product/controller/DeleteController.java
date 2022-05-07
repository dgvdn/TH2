package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import product.model.Music;
import product.repository.MusicRepository;

@Slf4j
@Controller
@RequestMapping("/delete")
public class DeleteController {

	private final MusicRepository musicRepository;

	@Autowired
	public DeleteController(MusicRepository musicRepository) {
		this.musicRepository = musicRepository;
	}

	@GetMapping("/{id}")
	public String edit(@PathVariable("id") String id, Model model) {
		Music music = musicRepository.findById(id);
		model.addAttribute("music", music);
		return "delete";
	}
	@PostMapping("/{id}")
	public String deleteProduct(String id) {
		try {
			musicRepository.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/display/";
	}
	@PostMapping("/no")
	public String no() {
		return "redirect:/display";
	}
}
