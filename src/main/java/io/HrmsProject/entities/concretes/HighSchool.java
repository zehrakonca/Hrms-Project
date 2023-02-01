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
@Table(name="high_school")
@AllArgsConstructor
@NoArgsConstructor
public class HighSchool {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public int id;
	
	@Column(name="high_school_name")
	private String highSchoolName;
	
	@ManyToOne()
	@JoinColumn(name="high_school_type_id")
	private HighSchoolType highSchoolType;
	
	@NotBlank
	@NotNull
	@JoinColumn(name="program_id")
	private ProgramHighSchool program;
	
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
