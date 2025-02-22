package com.example.haouas.apirest;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
	
import com.example.haouas.entities.Produit;
import com.example.haouas.service.IServiceProduit;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class productRestController {
	private IServiceProduit sp;
	
	@GetMapping("/products")
	public List<Produit> getAllProducts()
	{
		return sp.getAllProducts();	
	}
	@GetMapping("/products/{id}")
	public Produit getProductById(@PathVariable int id) {
		return sp.getProduct(id);
	}
	
	@DeleteMapping("/delete")
	public  void deletePoduct(@PathVariable int id)
	{
		sp.deleteProduct(id);
	}
	@PostMapping("/products/add")
	public void addProduct (@RequestBody Produit P) throws SQLException{
		sp.addProduct(P);
	}
	
	
	
}
