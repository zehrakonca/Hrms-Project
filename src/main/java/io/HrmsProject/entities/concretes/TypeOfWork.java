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

@Data
@Entity
@Table(name="type_of_works")
@NoArgsConstructor
@AllArgsConstructor
public class TypeOfWork {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="work_type_id")
	private int typeOfWorkId;
	
	@Column(name="work_type_name")
	private String typeOfWork;
	
	@OneToMany(mappedBy = "typeOfWork")
	private List<JobAdvertisement> jobAdvertisements;
	

}
