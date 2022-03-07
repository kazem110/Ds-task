package controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import  entity.Department;
import  entity.Employee;
import  service.TestService;


@RestController
@RequestMapping(path = "employee")
public class TestController {
	@Autowired
	private TestService testService;
	
//	@RequestMapping(value= "/v1.0/getemployee/{id}", method = RequestMethod.GET)
//	public Optional<Employee> getEmployeeById(@PathVariable Long id) throws IOException {
//	return testService.getEmployeeById(id);
	
	
	@GetMapping(path = "v1.0/getemployee/{Department_Name}")
	public ResponseEntity<?>getEmployee(@PathVariable("Department_Name") String Department_Name) {
		try {
			return new ResponseEntity<>(testService.getEmployeeByDepartment_Name(Department_Name), HttpStatus.OK);
			}
	 catch (Exception ex ) {
	}
		return null;
	}

	
	@RequestMapping(method = RequestMethod.POST, value = "insertdepartment", produces = "application/json")
	public ResponseEntity<?> addDepartment(@RequestBody Department dept) {

		try {
			return new ResponseEntity<>(testService.addDepartment(dept), HttpStatus.OK);
			}
	 catch (Exception ex ) {
	}
		return null;
	}
	
	@GetMapping(path = "getalldepartment")
	public ResponseEntity<?> getAllDepartment() throws IOException {
		return new ResponseEntity<>(testService.getAllDepartment(), HttpStatus.OK);
	}

	
	@RequestMapping(method = RequestMethod.POST, value = "insertobjdepartment", produces = "application/json")
	public ResponseEntity<?> addObjDepartment(@RequestBody Object object) {

		try {
			return new ResponseEntity<>(testService.insertDepartment(object), HttpStatus.OK);
			}
	 catch (Exception ex ) {
	}
		return null;
}
}
