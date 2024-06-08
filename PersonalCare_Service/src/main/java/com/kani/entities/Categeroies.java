package com.kani.entities;

import java.util.Date;
import java.util.Set;

import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Categeroies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categeroies_id;
	private String categoryName;
	private String createdBy;
	private String updatedBy;
	@CurrentTimestamp
	private Date creationTime;
	@UpdateTimestamp
	private Date updateTime;
	@OneToMany(targetEntity = Product.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "categeroies_id", referencedColumnName = "categeroies_id")
	private Set<Product> products;
	@ManyToOne(targetEntity=PersonalCare.class,cascade = CascadeType.ALL)
	@JoinColumn(name="personalCare_id")
	private PersonalCare personalCare;

}
