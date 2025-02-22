package com.example.haouas.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.haouas.entities.Categorie;
import com.example.haouas.entities.Produit;
import com.example.haouas.service.IServiceCategory;
import com.example.haouas.service.IServiceProduit;


import lombok.AllArgsConstructor;

@Controller 
@AllArgsConstructor

public class CategorieController {
	private IServiceCategory ca;
	public  CategorieController(IServiceCategory ca) {
		super();
		this.ca=ca;
	}
	@GetMapping ("/addcatpage")
	public String getAllCategorie(Model m) throws SQLException {
		List<Categorie>l =ca.getAllCategories();
		m.addAttribute("categorie",l);
		return "addCategoryPage";
	}
	
	
	
	@PostMapping ("addCategory")
	public String addCategorie(@RequestParam("nom") String nom) throws SQLException {
	    
	    Categorie CA = new Categorie(0, nom, null);
	    
	    
	    
	    ca.addCategorie(CA); 
	    
	    return "redirect:/addcatpage";
	}
	
	@GetMapping("/deletecat")
	public String deleteProduct(@RequestParam("id") int id) throws SQLException {
	  
	    ca.deleteCategorie(id);
	    
	    
	    return "redirect:/addcatpage"; 
	}
	@GetMapping("/searchs")
	public String searchProducts(@RequestParam("mc") String MC, Model m) throws SQLException {
	   
	    List<Categorie> L = ca.getCategorieByMC(MC);
	    m.addAttribute("categorie", L);
	    return "addCategoryPage";
	    

	   
	}

	

}