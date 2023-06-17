package io.HrmsProject.entities.concretes;

import java.time.LocalDateTime;

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
@Table(name="job_applications")
@NoArgsConstructor
@AllArgsConstructor
public class JobApplication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int applicationId;
	
	@ManyToOne()
	@JoinColumn(name="jobSeeker_id")
	private JobSeeker jobSeeker;
	
	@ManyToOne()
	@JoinColumn(name="advertisement_id")
	private JobAdvertisement jobAdvertisement;
	
	@Column(name="application_date")
	private LocalDateTime applicationDate;

}
