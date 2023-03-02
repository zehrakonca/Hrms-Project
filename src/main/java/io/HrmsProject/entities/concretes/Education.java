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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="educations")
@NoArgsConstructor
@AllArgsConstructor
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="education_id")
	private int educationId;

	@ManyToOne
	@JoinColumn(name="education_type_id")
	private EducationType educationType;

	@ManyToOne
	@JoinColumn(name="university_id")
	private University university;
	
	@ManyToOne
	@JoinColumn(name="faculty_id")
	private Faculty faculty;
	
	@ManyToOne()
	@JoinColumn(name="program_id")
	private ProgramInfo program;
	
	@Column(name="started_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startedDate;
	
	@Column(name="graduation_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate graduationDate;
	
	@ManyToOne()
	@JoinColumn(name="jobSeeker_id")
	private JobSeeker jobSeeker;
	
	
	
	

}
