package com.example.haouas.service;

import com.example.haouas.entities.Categorie;
import com.example.haouas.entities.Produit;
import com.example.haouas.repository.CategorieRepository;
import com.example.haouas.repository.ProduitRepository;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class CategorieServiceImpl implements IServiceCategory {
	 @Autowired
	  private CategorieRepository categorieRepository;
	@Override
	public void addCategorie(Categorie c) {
		// TODO Auto-generated method stub
		 categorieRepository.save(c);
	}

	public CategorieServiceImpl(CategorieRepository categorieRepository) {
		super();
		this.categorieRepository = categorieRepository;
	}

	@Override
	public List<Categorie> getAllCategories() {
		// TODO Auto-generated method stub
		 return categorieRepository.findAll();
	}

	@Override
	public Categorie getCategorie(int id) {
		return categorieRepository.findById(id).get();
	}

	@Override
	public void deleteCategorie(int id) {
		// TODO Auto-generated method stub
	
		
		categorieRepository.deleteById(id);
	}

	@Override
	public List<Categorie> getCategorieByMC(String MC) {
		// TODO Auto-generated method stub
		return categorieRepository.findByNameContaining(MC);
	}

   
}
