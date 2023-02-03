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

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="program_infos")
@NoArgsConstructor
@AllArgsConstructor
public class ProgramInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="program_id")
	private int program_id;
	
	@NotNull
	@NotBlank
	@Column(name="program_name")
	private String program;
	
	@OneToMany(mappedBy="program", cascade = CascadeType.ALL)
	private List<HighSchool> highschools;
	
	
}
