package com.example.haouas.repository;

import com.example.haouas.entities.Categorie;
import com.example.haouas.entities.Produit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

	@Query("SELECT p FROM Categorie p WHERE p.nom LIKE %:x%")
    List<Categorie> findByNameContaining(@Param("x") String nom);
 


}