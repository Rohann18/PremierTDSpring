package com.inti.controller;

import com.inti.model.Soliste;
import com.inti.service.ISolisteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("soliste")
public class SolisteController {

	@Autowired
	ISolisteService solisteService;
	
	@GetMapping("formulaireSoliste")
	public String getFormulaireSoliste() {
		return "formulaireSoliste";
	}
	
	@PostMapping("saveSoliste")
	public String saveSoliste(@ModelAttribute("soliste") Soliste s) {
		solisteService.saveSoliste(s);
		return "redirect:getAllSoliste";
	}
	
	@GetMapping("getAllSoliste")
	public String getAllSoliste(Model m) {
		m.addAttribute("listeSoliste", solisteService.getAllSoliste());
		return "tableSoliste";
	}
	
	@GetMapping("getSoliste")
	public String getSoliste(@RequestParam(value="id") Long id, Model m) {
		m.addAttribute("listeSoliste", solisteService.getSoliste(id));
		return "tableSoliste";
	}
	
	@PostMapping("updateSoliste")
	public String updateSoliste(@ModelAttribute("solist") Soliste s, Model m) {
		solisteService.updateSoliste(s);
		return "redirect:/soliste/getAllSoliste";
	}
	
	@DeleteMapping("deleteSoliste/{id}")
	public String deleteSoliste(@PathVariable(value = "id") Long id, Model m) {
		solisteService.deleteSoliste(id);
		return "redirect:/soliste/getAllSoliste";
	}
	
	@GetMapping("modifSoliste/{id}")
	public String modifSoliste(@PathVariable(value = "id") Long id, Model m) {
		m.addAttribute("soliste", solisteService.getSoliste(id));
		return "modifSoliste";
	}
}
