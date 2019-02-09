package com.luv2code.com.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.com.cruddemo.dao.EmployeeRepository;
import com.luv2code.com.cruddemo.entity.Employee;
import com.luv2code.com.cruddemo.rest.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	
	
	@Override
	public List<Employee> getAll() {
		
		return this.employeeRepository.findAll();
	}

	
	@Override
	public Employee getById(int employeeId) {
		
		Optional<Employee> result = this.employeeRepository.findById(employeeId);
		Employee theEmployee=null;
		if(result.isPresent()) {
			theEmployee=result.get();
		}
		else {
			throw new EmployeeNotFoundException("Employee Not Found");
		}
		return theEmployee;
	}

	
	@Override
	public void save(Employee employee) {
		this.employeeRepository.save(employee);
	}

	
	@Override
	public void delete(int employeeId) {
		this.employeeRepository.deleteById(employeeId);
	}

}
