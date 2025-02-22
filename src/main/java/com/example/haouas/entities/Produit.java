package com.example.haouas.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@Getter// Generates getters, setters, toString, equals, and hashCode methods
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with arguments for all fields
public class Produit {

  

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double prix;
    private int quantite;

    @ManyToOne
    @JoinColumn(name = "categorie_nom") 
    private Categorie categorie;

	public Produit(String name, double prix, int quantite, Categorie categorie) {
		super();
		this.name = name;
		this.prix = prix;
		this.quantite = quantite;
		this.categorie = categorie;
	}

	public Produit(int id, String name, double prix, int quantite, Categorie categorie) {
		super();
		this.id = id;
		this.name = name;
		this.prix = prix;
		this.quantite = quantite;
		this.categorie = categorie;
	}
public  Produit () {
	
}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

    
}
