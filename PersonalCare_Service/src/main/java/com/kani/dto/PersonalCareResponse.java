package com.kani.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class PersonalCareResponse {
	
	private int id;
	private String personalCareName;
	private String categoryName;

}
