package tech.getarrays.employeemanager;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tech.getarrays.employeemanager.service.EmployeeService;
import tech.getarrays.employeemanager.model.Employee;
@RestController
@RequestMapping("/")
public class EmployeeResouce {
	@Autowired
private final EmployeeService employeeService;

public EmployeeResouce(EmployeeService employeeService) {
	this.employeeService=employeeService;
}

@GetMapping("/")
public String hi(){
	List<Employee> employees=employeeService.finadAllEmployees();
	return "Welcome to INFINX";
}

@GetMapping("/bills")
public ResponseEntity<List<Employee>> getAllEmployees(){
	List<Employee> employees=employeeService.finadAllEmployees();
	return new ResponseEntity<>(employees,HttpStatus.OK);
}


@RequestMapping(value = "/bills/{id}", method = RequestMethod.GET)
public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
	Employee employees=employeeService.findEmployeeById(id);
	return new ResponseEntity<>(employees,HttpStatus.OK);
    
}

//@RequestMapping(method = RequestMethod.GET)
//public ResponseEntity<Employee> getEmployeeById(@RequestParam(value="date") String date) {
//	Employee employees=employeeService.findEmployeeByDate(date);
//	return new ResponseEntity<>(employees,HttpStatus.OK);
//}

//@GetMapping("/bills/{id}")
//public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
//	Employee employees=employeeService.findEmployeeById(id);
//	return new ResponseEntity<>(employees,HttpStatus.OK);
//}

@GetMapping("/bills/due/{date}")
public ResponseEntity<Employee> getEmployeeById(@PathVariable("date") String date){
	Employee employees=employeeService.findEmployeeByDate(date);
	return new ResponseEntity<>(employees,HttpStatus.OK);
}

@PostMapping("/add")
public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
	Employee newemployees=employeeService.addEmployee(employee);
	return new ResponseEntity<>(newemployees,HttpStatus.CREATED);
}

@PutMapping("/update")
public ResponseEntity<Employee> UpdateEmployee(@RequestBody Employee employee){
	Employee newemployees=employeeService.updateEmployee(employee);
	return new ResponseEntity<>(newemployees,HttpStatus.OK);
}

@DeleteMapping("/delete/{id}")
public ResponseEntity<?> DeleteEmployee(@PathVariable("id") Long id){
	employeeService.deleteEmployee(id);
	return new ResponseEntity<>(HttpStatus.OK);
}


}
