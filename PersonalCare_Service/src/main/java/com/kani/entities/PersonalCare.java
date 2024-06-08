package com.kani.entities;

import java.util.Date;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
public class PersonalCare {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personalCare_id;
	private String personalCareName;
	
	@OneToMany(targetEntity = Categeroies.class,cascade = CascadeType.ALL)
	@JoinColumn(name="personalCare_id",referencedColumnName = "personalCare_id")
	private Set<Categeroies> categeroies;
	private String updatedBy;
	private String createdBy;
	private Date creationTime;
	private Date updatedTime;

}
