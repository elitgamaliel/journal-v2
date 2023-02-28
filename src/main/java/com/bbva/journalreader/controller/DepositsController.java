package com.bbva.journalreader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DepositsController {

	@GetMapping("/deposit")
	public String index(Model model) {
		model.addAttribute("titulo", "JournalReader");
		return "deposits/deposit";
	}
}
