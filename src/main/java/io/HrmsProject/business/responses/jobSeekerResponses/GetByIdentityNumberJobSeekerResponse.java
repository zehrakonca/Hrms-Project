package io.HrmsProject.business.responses.jobSeekerResponses;

import io.HrmsProject.business.responses.userResponses.GetAllUserResponses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdentityNumberJobSeekerResponse extends GetAllUserResponses{
	
	public int date;
}
