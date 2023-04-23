package io.HrmsProject.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import io.HrmsProject.core.entities.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="system_employees")
@EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(name="id", referencedColumnName = "id")
public class SystemEmployee extends User{
	
	

}
