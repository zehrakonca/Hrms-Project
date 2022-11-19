package io.HrmsProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import io.HrmsProject.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","jobAdvertisements"})
@PrimaryKeyJoinColumn(name="id", referencedColumnName = "id")
public class Employer extends User{
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_site_name")
	private String webSiteName;
	
	@Column(name="company_mail")
	private String companyMail;
	
	@Column(name="company_description")
	private String companyDescription;
	
	
	

}
