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

import com.kani.dto.PersonalCareResponse;
import com.kani.entities.PersonalCare;
import com.kani.services.PersonalCareService;

@RestController
@RequestMapping("/personalCare")
public class PersonalCareController {
	
	@Autowired
	private PersonalCareService service;
	@GetMapping("/all")
	public List<PersonalCareResponse> getAllPersonalCare() {
		
		return service.getAllPersonalCare();
		
	}
	@PostMapping("/save")
	public ResponseEntity<String>addPersonalCare(@RequestBody PersonalCare personalCare) {
		
			try {
				service.addPersonalCare(personalCare);
				return new ResponseEntity<>("successfully inserted",HttpStatus.CREATED);
			} catch (Exception e) {
				
				return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);	
			}
	}
	
	@GetMapping("/{personalCareName}")
	public ResponseEntity<PersonalCare>getPesonalCareByName(@PathVariable String personalCareName){
		PersonalCare response=service.getPersonalCareByName(personalCareName);
		return new ResponseEntity<>(response,HttpStatus.CREATED);	
	}
	@PutMapping("/update")
	public ResponseEntity<String>updatePersonalCare(@RequestBody PersonalCare personalCare){
		service.updatePersonalCare(personalCare);
		return new ResponseEntity<>("updated Successfully",HttpStatus.CREATED);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>deletePersonalCare(@PathVariable Integer id){
		try {
			service.deletePersonalCareById(id);
			return new ResponseEntity<>("deleted Successfully",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/count")
	public Long personalCareCount() {
		return service.personalCareCount();
	}
}
