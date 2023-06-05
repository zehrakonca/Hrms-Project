package io.HrmsProject.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="sectors")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Sector {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="sector_id")
	public int sectorId;
	
	@Column(name="sector_name")
	public String sector;	
	
	@OneToMany(mappedBy = "sector")
	private List<JobAdvertisement> jobAdvertisements;
	
	@OneToMany(mappedBy = "sector")
	private List<JobExperience> jobExperiences;

}
