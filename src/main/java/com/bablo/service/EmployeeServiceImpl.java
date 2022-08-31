/**
 * 
 */
package com.bablo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bablo.model.Employee;
import com.bablo.repository.EmployeeRepository;

/**
 * @author bablo
 *
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> updateEmployee(Employee employee) {
		Optional<Employee> employeeInRepository =  employeeRepository.findById(employee.getId());
		if(employeeInRepository.isPresent()) {
			Employee employeeRepo = employeeInRepository.get();
			employeeRepo.setFirstName(employee.getFirstName());
			employeeRepo.setLastName(employee.getLastName());
			employeeRepo.setEmail(employee.getEmail());
			employeeRepo.setDepartment(employee.getDepartment());
			employeeRepo.setManagerId(employee.getManagerId());
			employeeRepo.setSalary(employee.getSalary());
			employeeRepo.setDateOfBirth(employee.getDateOfBirth());
			return Optional.of(employeeRepository.save(employeeRepo));
		}else {
			return Optional.empty();
		}
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		employeeRepository.delete(employee);
		if(employeeRepository.findById(employee.getId()).isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public Optional<Employee> getEmployeeById(Long Id) {
		return employeeRepository.findById(Id);
	}

	@Override
	public boolean deleteEmployeeById(long id) {
		employeeRepository.deleteById(id);
		if(employeeRepository.findById(id).isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public Employee getEmployee(Employee employee) {
		return employeeRepository.getById(employee.getId());
	}

}
