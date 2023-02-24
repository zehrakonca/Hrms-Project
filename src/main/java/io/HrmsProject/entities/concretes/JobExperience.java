package io.HrmsProject.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_experiences")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class JobExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="experience_id")
	private int experienceId;

	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="position")
	private String position;
	
	@Column(name= "job_description")
	private String jobDescription;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@Column(name="started_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startedDate;
	
	@Column(name="end_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	
	@ManyToOne
	@JoinColumn(name="sector_id")
	private Sector sector;
	
	@ManyToOne()
	@JoinColumn(name="jobSeeker_id")
	private JobSeeker jobSeeker;

}
