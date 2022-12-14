package io.HrmsProject.entities.concretes;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="sectors")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobs" })
public class Sector {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="sector_id")
	public int sectorId;
	
	@Column(name="sector_name")
	public String sector;
	
	@OneToMany(mappedBy = "sector", cascade = CascadeType.ALL)
	private List<Job> jobs;

}
