package io.HrmsProject.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Table(name="job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="advertisement_id")
	private int advertisementId;
	
	@Column(name="advertisement_name")
	private String advertisementName;
	
	@ManyToOne
	@JoinColumn(name="sector_id")
	private Sector sector;
	
	@ManyToOne
	@JoinColumn(name="job_id")
	private Job job;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@Column(name="number_of_vacancies")
	private int numberOfVacancies;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="job_salary_min")
	private int jobSalaryMin;
	
	@Column(name="job_salary_max")
	private int jobSalaryMax;
	
	@Column(name="release_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime releaseDate;
	
	@Column(name="application_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate applicationDate;
	
	@Column(name="is_active")
	private boolean isActive;

}
