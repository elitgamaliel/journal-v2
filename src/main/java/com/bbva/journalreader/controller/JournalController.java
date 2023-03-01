package com.bbva.journalreader.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bbva.journalreader.buscar.Buscar;

@Controller
public class JournalController {

	@GetMapping("/journal")
	public String index(Model model) {
		model.addAttribute("titulo", "JournalReader");
		return "journal";
	}

	@PostMapping("/buscar")
	public String buscar(@RequestParam("archivos") MultipartFile[] archivos, Model model) {
		model.addAttribute("titulo", "JournalReader");
		Buscar buscar = new Buscar();
		List<String> fechas = new ArrayList<>();
		int tipo = buscar.getTipoOperacion(archivos);// RETIRO:1, DEPOSITOS:2, DEFAULT: 3
		int remesa = buscar.getSizeRemesa(archivos);
		if (tipo == 1) {
			if (remesa > 0) {
				for (int k = 0; k < buscar.getSizeRemesa(archivos); k++) {
					fechas.add(buscar.getFechaAbastecimiento(archivos, k));
				}
				model.addAttribute("info", buscar.getAtm(archivos));
			} else {
				model.addAttribute("message", "No existen abastecimientos, verifica diarios");
			}
			model.addAttribute("operacion", "RETIRO");
		} else if (tipo == 2) {
			if (remesa > 0) {
				for (int k = 0; k < buscar.getSizeRemesa(archivos); k++) {
					fechas.add(buscar.getFechaAbastecimiento(archivos, k));
				}
				model.addAttribute("info", buscar.getAtm(archivos));
			} else {
				model.addAttribute("message", "No existen abastecimientos, verifica diarios");
			}
			model.addAttribute("operacion", "DEPOSITO");
		} else if (tipo == 3) {
			model.addAttribute("message", "No se leyeron los archivos");
		} else {
			model.addAttribute("message", "Pf verifica el contenido de tus archivos");
		}
		model.addAttribute("fechas", fechas);
		return "/journal";
	}

}