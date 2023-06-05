package io.HrmsProject.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.HrmsProject.business.abstracts.TypeOfWorkService;
import io.HrmsProject.business.requests.typeOfWorkRequests.CreateTypeOfWorkRequest;
import io.HrmsProject.business.requests.typeOfWorkRequests.UpdateTypeOfWorkRequest;
import io.HrmsProject.business.responses.typeOfworkResponses.GetAllTypeOfWorkResponse;
import io.HrmsProject.business.responses.typeOfworkResponses.GetByIdTypeOfWorkResponse;
import io.HrmsProject.core.utilities.results.DataResult;

@RestController
@RequestMapping("api/workTypes")
@CrossOrigin
public class TypeOfWorksController {

	private TypeOfWorkService typeOfWorkService;

	@Autowired
	public TypeOfWorksController(TypeOfWorkService typeOfWorkService) {
		super();
		this.typeOfWorkService = typeOfWorkService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllTypeOfWorkResponse>> getAll(){
		return typeOfWorkService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<GetByIdTypeOfWorkResponse> getById(@RequestParam() int id){
		return typeOfWorkService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid CreateTypeOfWorkRequest createWorkType) throws Exception {
		this.typeOfWorkService.add(createWorkType);
		
	}
	
	@PutMapping("/update")
	public void update(@RequestBody UpdateTypeOfWorkRequest updateWorkType) throws Exception {
		this.typeOfWorkService.update(updateWorkType);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestParam() int id) {
	 this.typeOfWorkService.delete(id);
	}
}
