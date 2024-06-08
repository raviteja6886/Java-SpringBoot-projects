package com.kani.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kani.entities.Categeroies;

public interface CategeroiesRepository extends JpaRepository<Categeroies,Integer> {

	Categeroies findByCategoryName(String categoryName);

	void deleteByCategoryName(String categoryName);

}
