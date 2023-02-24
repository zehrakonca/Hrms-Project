package io.HrmsProject.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="faculties")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educations" })
public class Faculty {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="faculty_id")
	private int facultyId;
	
	@NotNull
	@NotBlank
	@Column(name="faculty_name")
	private String faculty;
	
	@OneToMany(mappedBy="faculty", cascade = CascadeType.ALL)
	private List<Education> educations;

}
