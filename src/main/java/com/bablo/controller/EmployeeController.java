/**
 * 
 */
package com.bablo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bablo.model.Employee;
import com.bablo.service.EmployeeService;

/**
 * @author bablo
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public String helloWorld() {
		return "HelloWorld";
	}
	
	@GetMapping("/display")
	public String viewAllEmployee(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "employeeDisplay";
	}
	
	@GetMapping("/new")
	public String showNewEmployeeForm(Model model) {
		Employee emp = new Employee();
		model.addAttribute("employee", emp);
		return "newemployee";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "employeeSavedMsg";
	}
	
	@GetMapping("/updateForm/{id}")
	public String updateForm(@PathVariable(value = "id") long id, Model model) {
		return "updateForm";
	}
	
    
	@PutMapping("/update")
	public String updateEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.updateEmployee(employee);
		return "employeeSavedMsg";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable(value = "id")long id) {
		if(employeeService.deleteEmployeeById(id)) {
			return "deletedSuccessfully";
		}else {
			return "couldNtDelete";
		}
	}
}
