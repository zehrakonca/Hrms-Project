package io.HrmsProject.entities.concretes;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
	
	private int id;
	
	private LocalDateTime createdDate;
	
	private JobSeeker jobSeeker;
	
	private CoverLetter coverLetter;
	
	
	

}
