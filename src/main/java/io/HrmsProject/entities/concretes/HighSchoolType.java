package io.HrmsProject.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="high_school_types")
@NoArgsConstructor
@AllArgsConstructor
public class HighSchoolType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="type_id")
	private int highSchoolTypeId;
	
	@NotNull
	@NotBlank
	@Column(name="high_school_type_name")
	private String highSchoolType;
	
	@OneToMany(mappedBy = "highSchoolType")
	private List<HighSchool> highSchools;

}
