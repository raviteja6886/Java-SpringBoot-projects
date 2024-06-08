package com.kani.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kani.dto.ProductResponse;
import com.kani.entities.Product;
import com.kani.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	

	public List<ProductResponse> getProducts() {
		 List<ProductResponse>responseList=new ArrayList<>();
		
		 List<Product>productList=productRepo.findAll();
		 if(productList.size()>0) {
			 for(Product p  : productList) {
				 ProductResponse ps=new ProductResponse();
				 ps.setProductId(p.getProductId());
				 ps.setProductName(p.getProductName());
				 ps.setProductPrice(p.getPrice());
				 responseList.add(ps);
			 }
		 }
		 
		return responseList;
	}

	public Product saveProduct(Product product) {

		product.setCreationTime(new Date());
	
		
		return productRepo.save(product);

	}

	public Product updateProduct(Product product) {
		
		Date d = new Date();
		product.setUpdateTime(d);
		Product p=productRepo.findById(product.getProductId()).get();
		product.setCreationTime(p.getCreationTime());
		
		return productRepo.save(product);
	}
	
	public void deleteProductById(Integer id) {
	
		Product product = productRepo.findById(id).get();
		if(product == null) {
			
			throw new NullPointerException("product is not found");
		}
		productRepo.deleteById(id);
	}
	
	public void deleteProductByName(String productName) {
		
		Product product = productRepo.findByProductName(productName);
		if(product == null) {
			
			throw new NullPointerException("product is not found");
		}
		productRepo.deleteByProductName(productName);
		
	}
	
	public Product getProductByName(String productName) {
		
		return productRepo.findByProductName(productName);
	}
	
	public long getProductCount() {
		return productRepo.count();
	}

}
