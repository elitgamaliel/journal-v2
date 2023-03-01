package com.bbva.journalreader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JournalController {

	@GetMapping("/journal")
	public String index(Model model) {
		model.addAttribute("titulo", "JournalReader");
		return "journal";
	}

	@PostMapping("/buscar")
	public String buscar(Model model) {
		model.addAttribute("titulo", "JournalReader");
		return "journal";
	}
}