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
import org.springframework.web.bind.annotation.RestController;

import com.kani.entities.Categeroies;
import com.kani.entities.Product;
import com.kani.services.CategeroiesService;
@RestController
@RequestMapping("/categeroies")
public class CategeroiesController {
	@Autowired
	private CategeroiesService categeroiesService;
	
	@GetMapping("/getAllCategeroies")
	public List<Categeroies> getAllCategeroies(){
		
		return categeroiesService.getCategeroies();
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> addCategory(@RequestBody Categeroies categeroies){
		
		categeroiesService.saveCategeroies(categeroies);
		
		return new ResponseEntity<>("inserted successfully",HttpStatus.CREATED);
	}
	@PutMapping("/update")
	public ResponseEntity<String> updateCategory(@RequestBody Categeroies categeroies ){
		categeroiesService.updateCategeroies(categeroies);
		return new ResponseEntity<>("updated successfully",HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCategoryById(@PathVariable Integer id) {
		
		categeroiesService.deleteCategoryById(id);
		
		return new ResponseEntity<>("deleted Successfully",HttpStatus.OK);
	}
	@DeleteMapping("/{categoryName}")
	public ResponseEntity<String>deleteCategoryByName(@PathVariable String categoryName) {
		
		categeroiesService.deleteCategoryByName(categoryName);
		
		return new ResponseEntity<>("deleted Successfully",HttpStatus.OK);
	}
	
	@GetMapping("/{categoryName}")
	public ResponseEntity<Categeroies> getCategoryByName(@PathVariable String categoryName) {
		
		Categeroies response=categeroiesService.getCategoryByName(categoryName);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public Long getCategeroiesCount() {
		
		return categeroiesService.getCategeroiesCount();	}
	
	
}
