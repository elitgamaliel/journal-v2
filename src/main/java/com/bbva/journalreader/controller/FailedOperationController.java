package com.bbva.journalreader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FailedOperationController {

	@GetMapping("/failedOperations")
	public String index(Model model) {
		model.addAttribute("titulo", "JournalReader");
		return "failedOperations/failedOperations";
	}
}
