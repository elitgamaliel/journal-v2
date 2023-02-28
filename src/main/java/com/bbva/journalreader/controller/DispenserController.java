package com.bbva.journalreader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DispenserController {

	@GetMapping("/dispenser")
	public String index(Model model) {
		model.addAttribute("titulo", "JournalReader");
		return "dispenser/dispenser";
	}
}
