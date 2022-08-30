/**
 * 
 */
package com.bablo.service;

import java.util.List;
import java.util.Optional;

import com.bablo.model.Employee;

/**
 * @author bablo
 *
 */
public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	
	void saveEmployee(Employee employee);

    Optional<Employee> updateEmployee(Employee employee);
    
    boolean deleteEmployee(Employee employee);
    
    Optional<Employee> getEmployeeById(Employee employee);

	boolean deleteEmployeeById(long id);

}
