package io.HrmsProject.business.responses.jobSeekerResponses;

import io.HrmsProject.business.responses.userResponses.GetAllUserResponses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdJobSeekerResponse extends GetAllUserResponses{
	
	private int id;
	private int date;
	
}
