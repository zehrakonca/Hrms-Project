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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="high_school_type")
@AllArgsConstructor
@NoArgsConstructor
public class HighSchoolType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="high_school_type_id")
	public int highSchoolTypeId;
	
	@Column(name="high_school_type")
	private String highSchoolType;
	
	@OneToMany(mappedBy="highSchoolType", cascade = CascadeType.ALL)
	private List<HighSchool> highSchool;

}
