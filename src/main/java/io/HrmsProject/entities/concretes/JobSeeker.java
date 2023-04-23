package io.HrmsProject.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.HrmsProject.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="jobSeekers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(name="id", referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educations" })
public class JobSeeker extends User{
	
	@Column(name="national_identity")
	private String nationalIdentity;
	
	@Column(name="date")
	private int date;
	
	@OneToMany(mappedBy="jobSeeker")
	private List<LanguageInfo> languageInfos;
	
	@OneToMany(mappedBy="jobSeeker")
	private List<JobExperience> jobExperiences;
	
	@OneToMany(mappedBy="jobSeeker")
	private List<Education> educations;
	
	@OneToMany(mappedBy="jobSeeker")
	private List<Ability> abilities;
	
	@OneToMany(mappedBy="jobSeeker")
	private List<FavoriteJobAdvertisement> favoriteJobAdvertisements;
	
	
	
}
