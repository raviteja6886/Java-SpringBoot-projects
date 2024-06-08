package com.kani.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ProductResponse {
	private int productId;
	private String productName;
	private double productPrice;

}
