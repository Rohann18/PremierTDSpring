package com.inti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("produit")
public class ProduitController {

	@GetMapping("affichage")
	public String affichageNomProduit(@RequestParam(value = "nom", defaultValue = "Samsung") String nom, Model m) {
		m.addAttribute("nom", nom);
		return "produit";
	}
	
	@GetMapping("prix")
	public String affichagePrixProduit(@RequestParam(value = "prix", defaultValue = "0") double prix, Model m) {
		m.addAttribute("prix", prix);
		return "prix";
	}
	
	@GetMapping("calcul")
	public String affichagePrixTTC(@RequestParam(value = "nom", defaultValue = "Samsung") String nom, @RequestParam(value = "prix", defaultValue = "0") double prix, Model m) {
		m.addAttribute("nom", nom);
		m.addAttribute("prix", prix);
		m.addAttribute("ttc", prix*1.2);
		return "ttc";
	}
}
