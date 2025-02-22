package com.example.haouas.controller;

import com.example.haouas.entities.*;
import com.example.haouas.service.IServiceCategory;
import com.example.haouas.service.IServiceProduit;


import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
//@RequestMapping("/produits")
public class ProduitController {

    public ProduitController(IServiceProduit produitService, IServiceCategory cat) {
		super();
		this.produitService = produitService;
		this.cat = cat;
	}
	private IServiceProduit produitService;
    private IServiceCategory cat ;

 
    
  

    @GetMapping("/all")
    public String getAllProducts(Model m) {
    	List<Produit> l=produitService.getAllProducts();
        m.addAttribute("products",l);
    	
        return "Home2";
    

   
    }
    @GetMapping("/search")
    public String getProduitByMc(@RequestParam("mc") String mc,Model m) {
    	
    	List<Produit> l=produitService.getProduitByMc(mc);
    	   m.addAttribute("products",l);
    	return "Home2";
    	}
    @GetMapping("/addpage")
	public String addProduct1(Model m ){
    	
		m.addAttribute("categories",cat.getAllCategories());
		
		
		return "ajout";
	}
    @PostMapping("/addProduct")
   

    public String addProduct(

            @RequestParam("Nom") String name,

            @RequestParam("Prix") double prix,

            @RequestParam("Quantite") int quantite,

            @RequestParam("categorieId") int categorieId,

            Model m) {




        Categorie categorie = cat.getCategorie(categorieId);




        Produit produit = new Produit(name, prix, quantite, categorie);




        produitService.addProduct(produit);




        m.addAttribute("products", produitService.getAllProducts());



      

        return "Home2";
}
    @GetMapping("/delete")

    public String deleteProduct(@RequestParam("id") int id, Model m) {

        produitService.deleteProduct(id); // Delete the product by its ID

        List<Produit> products = produitService.getAllProducts(); // Fetch the updated list of products

        m.addAttribute("products", products); // Add the updated list to the model

        return "Home2"; // Return the view to display all products

    }
    
   @GetMapping("/modifier")
   public String Modifier(@RequestParam("id") int id, Model m) {
	   m.addAttribute("product",produitService.getProduct(id));
	   m.addAttribute("categories",cat.getAllCategories());
	   
	   return "ajout";
	   
	   
   }
   @PostMapping("/Update")
   public String ModiferP(
		   @RequestParam("id") int id,

           @RequestParam("Nom") String name,

           @RequestParam("Prix") double prix,

           @RequestParam("Quantite") int quantite,

           @RequestParam("categorieId") int categorieId,

           Model m) {




       Categorie categorie = cat.getCategorie(categorieId);




       Produit produit = new Produit(id,name, prix, quantite, categorie);




       produitService.updateProduct(produit);




       m.addAttribute("products", produitService.getAllProducts());



     

       return "Home2";
   
    




} }
