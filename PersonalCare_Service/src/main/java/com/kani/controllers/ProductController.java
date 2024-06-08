package com.kani.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kani.dto.ProductResponse;
import com.kani.entities.Product;
import com.kani.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/allProducts")
	public List<ProductResponse> getAllProducts(){
		
		return productService.getProducts();
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> addProduct(@RequestBody Product product){
		
		productService.saveProduct(product);
		
		return new ResponseEntity<>("inserted successfully",HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateProduct(@RequestBody Product product ){
		productService.updateProduct(product);
		return new ResponseEntity<>("updated successfully",HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>deleteProductById(@PathVariable Integer id) {
		
		productService.deleteProductById(id);
		
		return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
	}
	
	@DeleteMapping("/{productName}")
	public ResponseEntity<String> deleteProductById(@PathVariable String productName) {
		
		productService.deleteProductByName(productName);
		
		return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
	}
	
	@GetMapping("/{productName}")
	public ResponseEntity<Product> getProudctByName(@PathVariable String productName) {
		
		Product productResponse=productService.getProductByName(productName);
		return new ResponseEntity<>(productResponse,HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public Long getProductsCount() {
		
		return productService.getProductCount();
	}
	
	

}
