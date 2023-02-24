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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="advertisement_id")
	private int advertisementId;
	
	@NotNull
	@NotBlank
	@Column(name="advertisement_name")
	private String advertisementName;
	
	@NotNull
	@NotBlank
	@ManyToOne
	@JoinColumn(name="sector_id")
	private Sector sector;
	
	@ManyToOne
	@NotNull
	@NotBlank
	@JoinColumn(name="job_id")
	private Job job;
	
	@ManyToOne()
	@NotNull
	@NotBlank
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne()
	@NotNull
	@NotBlank
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@NotNull
	@NotBlank
	@Column(name="number_of_vacancies")
	private int numberOfVacancies;
	
	@NotNull
	@NotBlank
	@Column(name="job_description")
	private String jobDescription;
	
	@NotNull
	@NotBlank
	@Column(name="job_salary_min")
	private int jobSalaryMin;
	
	
	@Column(name="job_salary_max")
	private int jobSalaryMax;
	
	@NotNull
	@NotBlank
	@Column(name="release_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime releaseDate;
	
	@NotNull
	@NotBlank
	@Column(name="application_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate applicationDate;
	
	@Column(name="is_active")
	private boolean isActive;

}
