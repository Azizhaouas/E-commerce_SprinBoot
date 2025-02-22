package com.example.haouas.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data // Generates getters, setters, toString, equals, and hashCode methods
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a full-argument constructor
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatic ID generation
    private int id;

    private String nom;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Produit> getListe() {
		return liste;
	}

	public Categorie(int id, String nom, List<Produit> liste) {
		super();
		this.id = id;
		this.nom = nom;
		this.liste = liste;
	}
	public Categorie( String nom) {
		
		this.nom = nom;
		
	}public Categorie( ) {
		
		
		
	}

	public void setListe(List<Produit> liste) {
		this.liste = liste;
	}
	@JsonIgnore
	@OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Produit> liste;
}
