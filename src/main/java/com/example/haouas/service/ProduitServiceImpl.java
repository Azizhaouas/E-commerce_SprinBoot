package com.example.haouas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.haouas.entities.Produit;
import com.example.haouas.repository.CategorieRepository;
import com.example.haouas.repository.ProduitRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class ProduitServiceImpl implements IServiceProduit {
	// @Autowired
	  private ProduitRepository pr;
	public ProduitServiceImpl(ProduitRepository pr) {
		super();
		this.pr = pr;
	}

	@Override

	public void addProduct(Produit p) {
		pr.save(p);
		
	}

	@Override
	public List<Produit> getAllProducts() {
		// TODO Auto-generated method stub
		 return pr.findAll();
	}

	@Override
	public List<Produit> getProduitByMc(String mc) {
		// TODO Auto-generated method stub
		return pr.findByNameContaining( mc);
	}

	@Override
	public Produit getProduct(int id) {
		// TODO Auto-generated method stub
		return pr.findById(id).get();
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		pr.deleteById(id);
	}

	@Override
	public void updateProduct(Produit p) {
		// TODO Auto-generated method stub
		pr.save(p);
		
	}

}
