package com.kani.services;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kani.entities.Categeroies;
import com.kani.entities.Product;
import com.kani.repositories.CategeroiesRepository;
import com.kani.repositories.PersonalCareRepository;
import com.kani.repositories.ProductRepository;

@Service
public class CategeroiesService {
	@Autowired
	private CategeroiesRepository categeroiesRepo;
	@Autowired
	private PersonalCareRepository personalcareRepo;
	@Autowired
	private ProductRepository productRepo;

	public List<Categeroies> getCategeroies() {

		return categeroiesRepo.findAll();
	}

	public Categeroies saveCategeroies(Categeroies categeroies) {

		/*
		 * Integer id = categeroies.getPersonalCare().getPersonalCare_id(); PersonalCare
		 * pc = personalcareRepo.findById(id).get(); categeroies.setPersonalCare(pc);
		 */
		categeroies.setCreationTime(new Date());
		return categeroiesRepo.save(categeroies);

	}
public Categeroies updateCategeroies(Categeroies categeroies) {
		
		categeroies.setUpdateTime(new Date());
		return categeroiesRepo.save(categeroies);
	}
	
	public void deleteCategoryById(Integer id) {
	
		Categeroies categeroies = categeroiesRepo.findById(id).get();
		if(categeroies == null) {
			
			throw new NullPointerException("product is not found");
		}
		categeroiesRepo.deleteById(id);
	}
	
	public void deleteCategoryByName(String categoryName) {
		
		Categeroies categeroies = categeroiesRepo.findByCategoryName(categoryName);
		if(categeroies == null) {
			
			throw new NullPointerException("category is not found");
		}
		categeroiesRepo.deleteByCategoryName(categoryName);
		
	}
	
	public Categeroies getCategoryByName(String categoryName) {
		Categeroies c =categeroiesRepo.findByCategoryName(categoryName);
		Product p =productRepo.findById(c.getCategeroies_id()).get();
		Set<Product>pList=new HashSet<>();
		pList.add(p);
		c.setProducts(pList);
		return c;
	}
	
	public long getCategeroiesCount() {
		return categeroiesRepo.count();
	}

}
