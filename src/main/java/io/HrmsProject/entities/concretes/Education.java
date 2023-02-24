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
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="educations")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="education_id")
	private int educationId;
	
	@NotNull
	@NotBlank
	@ManyToOne
	@JoinColumn(name="education_type_id")
	@JsonIgnore
	private EducationType educationType;
	
	@NotNull
	@NotBlank
	@ManyToOne
	@JoinColumn(name="university_id")
	@JsonIgnore
	private University university;
	
	@NotNull
	@NotBlank
	@ManyToOne
	@JoinColumn(name="faculty_id")
	@JsonIgnore
	private Faculty faculty;
	
	@NotNull
	@NotBlank
	@ManyToOne()
	@JoinColumn(name="program_id")
	@JsonIgnore
	private ProgramInfo program;
	
	@NotNull
	@NotBlank
	@Column(name="started_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startedDate;
	
	@NotNull
	@NotBlank
	@Column(name="graduation_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate graduationDate;
	
	@ManyToOne()
	@JoinColumn(name="jobSeeker_id")
	@JsonIgnore
	private JobSeeker jobSeeker;
	
	
	
	

}
