package tech.getarrays.employeemanager.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.getarrays.employeemanager.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Long>{

	//void deleteEmployeeById(Long id);
	public void deleteEmployeeById(long id);
	Optional<Employee> findEmployeeById(Long id);
	Optional<Employee> findEmployeeByDate(String date);

}
