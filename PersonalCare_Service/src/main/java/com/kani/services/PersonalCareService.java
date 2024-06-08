package com.kani.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kani.dto.PersonalCareResponse;
import com.kani.entities.PersonalCare;
import com.kani.repositories.PersonalCareRepository;

@Service
public class PersonalCareService {
	@Autowired
	private PersonalCareRepository personalCareRepo;
	
	public List<PersonalCareResponse> getAllPersonalCare() {
		return personalCareRepo.getCategeroies();
	}

	public PersonalCare addPersonalCare(PersonalCare personalCare) throws Exception {
		
		PersonalCare pc1=personalCareRepo.findByPersonalCareName(personalCare.getPersonalCareName());
		if(pc1 == null) {
			
			personalCare.setCreationTime(new Date());
			return personalCareRepo.save(personalCare);
		}
		else {
			throw new Exception("PersonalCare name is already exist");
		}
	}

	
	public PersonalCare updatePersonalCare(PersonalCare personalCare) {
		
		personalCare.setUpdatedTime(new Date());
		return personalCareRepo.save(personalCare);
	}
	
	public void deletePersonalCareById(Integer id) throws Exception {
		Optional<PersonalCare> pc = personalCareRepo.findById(id);
		
		
		if(pc.isPresent()) {
			personalCareRepo.deleteById(id);
			
		}
		else {
			throw new Exception("personal care id not found");
		}

	}
	
	
	public PersonalCare getPersonalCareByName(String categoryName) {

		return personalCareRepo.findByPersonalCareName(categoryName);
	}
	
	
	public long personalCareCount() {
		
		return personalCareRepo.count();
	}

}
