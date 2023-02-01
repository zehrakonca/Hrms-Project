package io.HrmsProject.entities.concretes;

import java.util.Date;

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
	@Column(name="id")
	private int id;
	
	@NotBlank
	@NotNull
	@ManyToOne()
	@JoinColumn(name="type_id")
	private EducationType educationType;
	
	@NotBlank
	@NotNull
	@ManyToOne()
	@JoinColumn(name="university_id")
	private University university;
	
	@NotBlank
	@NotNull
	@ManyToOne()
	@JoinColumn(name="program_id")
	private ProgramUniversity program;
	
	@NotBlank
	@NotNull
	@ManyToOne()
	@JoinColumn(name="faculty_id")
	private Faculty faculty;
	
	@NotBlank
	@NotNull
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="graduation_date")
	private Date graduationYear;
	
	@ManyToOne()
	@JoinColumn(name="jobSeeker_id")
	private JobSeeker jobSeeker;
	

}
