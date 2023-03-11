package io.HrmsProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="high_schools")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","programInfos"})
public class HighSchool {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="highSchool_id")
	private int highSchoolId;
	
	@NotNull
	@NotBlank
	@Column(name="hightSchool_name")
	private String highSchoolName;
	
	@ManyToOne()
	@JoinColumn(name="type_id")
	private HighSchoolType highSchoolType;
	
	@ManyToOne()
	@JoinColumn(name="program_id")
	private ProgramInfo program;
	
	@NotNull
	@NotBlank
	@Column(name="started_date")
	private int startedDate;
	
	@NotNull
	@NotBlank
	@Column(name="graduation_date")
	private int graduationDate;
	
	@ManyToOne()
	@JoinColumn(name="jobSeeker_id")
	private JobSeeker jobSeeker;
	

}
