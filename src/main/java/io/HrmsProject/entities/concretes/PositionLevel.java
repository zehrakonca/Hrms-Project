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
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="position_levels")
@AllArgsConstructor
@NoArgsConstructor
public class PositionLevel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="position_level_id")
	private int positionLevelId;
	
	@NotNull
	@NotBlank
	@Column(name="position_level_name")
	private String positionLevel;
	
	@OneToMany(mappedBy="positionLevel")
	private List<JobAdvertisement> jobAdvertisements;

}
