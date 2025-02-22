package com.example.haouas.service;

import java.util.List;

import com.example.haouas.entities.Categorie;



public interface IServiceCategory {
	 void addCategorie(Categorie c);
	    List<Categorie> getAllCategories();
	    Categorie getCategorie(int id);
	    void deleteCategorie(int id);
	    List<Categorie> getCategorieByMC(String MC);
	

}
