package io.HrmsProject.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="experiences")
@AllArgsConstructor
@NoArgsConstructor
public class Experience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="experience_type_id")
	private int experienceTypeId;
	
	@NotNull
	@NotBlank
	@Column(name="experience_name")
	private String experience;
	
	@OneToMany(mappedBy="experience")
	private List<JobAdvertisement> jobAdvertisements;
}
