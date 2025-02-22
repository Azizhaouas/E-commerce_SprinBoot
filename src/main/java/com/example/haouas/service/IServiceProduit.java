package com.example.haouas.service;

import java.util.List;

import com.example.haouas.entities.Produit;



public interface IServiceProduit {
	
		public  void addProduct(Produit p);
		List<Produit> getAllProducts();
		List<Produit> getProduitByMc(String mc);
		Produit getProduct(int id);
		void deleteProduct(int id) ;
		void updateProduct(Produit p) ;

	

}
