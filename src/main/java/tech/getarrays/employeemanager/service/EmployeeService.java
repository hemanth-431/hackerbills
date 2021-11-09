package tech.getarrays.employeemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repo.EmployeeRepo;

@Service
public class EmployeeService {
private final EmployeeRepo employeerepo;

@Autowired
public EmployeeService(EmployeeRepo employeerepo) {
	this.employeerepo = employeerepo;
}

public Employee addEmployee(Employee employee) {
	return employeerepo.save(employee);
}

public List<Employee> finadAllEmployees(){
	return employeerepo.findAll();
}
public Employee  updateEmployee(Employee employee) {
	return employeerepo.save(employee);
}
public Employee findEmployeeById(Long id) {
	return employeerepo.findEmployeeById(id)
			.orElseThrow(() -> new UserNotFoundException("Bill"+id+"not fount."));
}

public Employee findEmployeeByDate(String date) {
	return employeerepo.findEmployeeByDate(date)
			.orElseThrow(() -> new UserNotFoundException(date+"not fount."));
}

public void deleteEmployee(Long id) {
	Employee entity=employeerepo.getOne(id);
	employeerepo.delete(entity);
	//employeerepo.deleteEmployeeById(id);
//	employeerepo.deleteById(id);
}

}
