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

@Table(name="jobs")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_id")
	private int jobId;
	
	@Column(name="job_name")
	private String jobName;
	
	@ManyToOne()
	@JoinColumn(name="sector_id")
	private Sector sector;

}
