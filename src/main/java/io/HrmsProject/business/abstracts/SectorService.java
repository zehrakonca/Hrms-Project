package io.HrmsProject.business.abstracts;

import io.HrmsProject.business.requests.sectorRequests.CreateSectorRequests;
import io.HrmsProject.business.requests.sectorRequests.UpdateSectorRequests;
import io.HrmsProject.business.responses.sectorResponses.GetAllSectorResponse;
import io.HrmsProject.business.responses.sectorResponses.GetByIdSectorResponse;
import io.HrmsProject.entities.concretes.Sector;

public interface SectorService extends BaseEntityService<Sector, CreateSectorRequests, UpdateSectorRequests, GetAllSectorResponse,GetByIdSectorResponse>{

}
