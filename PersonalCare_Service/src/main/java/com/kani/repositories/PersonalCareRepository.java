package com.kani.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kani.dto.PersonalCareResponse;
import com.kani.entities.PersonalCare;

public interface PersonalCareRepository extends JpaRepository<PersonalCare, Integer> {

	PersonalCare findByPersonalCareName(String personalCareName);
	
	@Query("SELECT  new com.kani.dto.PersonalCareResponse(p.personalCare_id,p.personalCareName,c.categoryName) FROM PersonalCare p JOIN p.categeroies c")
	List<PersonalCareResponse>getCategeroies();
	
}
