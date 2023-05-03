package io.HrmsProject.entities.concretes;

import java.util.List;

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

@Table(name="military_Status")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MilitaryStatu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="military_statu_id")
	public int militaryStatuId;
	
	@Column(name="military_statu_name")
	public String militaryStatu;
	
	@OneToMany(mappedBy="militaryStatu")
	private List<JobAdvertisement> jobAdvertisements;

}
