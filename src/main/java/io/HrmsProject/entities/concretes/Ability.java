package io.HrmsProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="abilities")
@AllArgsConstructor
@NoArgsConstructor
public class Ability {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int abilityId;
	
	@Column(name="ability_name")
	private String abilityName;
	
	@ManyToOne
	@JoinColumn(name="jobSeeker_id")
	private JobSeeker jobSeeker;
	
}
