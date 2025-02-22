package com.example.haouas.repository;

import com.example.haouas.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

   
  
    //List<Produit> findbynameContains(String mc); // ya tekhdm b hetthy wala ili tahtha 
    @Query("SELECT p FROM Produit p WHERE p.name LIKE %:x%")
    List<Produit> findByNameContaining(@Param("x") String name);
 
}
