package com.tripurari.springbootdatabase.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripurari.springbootdatabase.models.Department;
import com.tripurari.springbootdatabase.repos.DepartmentRepo;

@Service
public class DepartmentService {
	
	private final DepartmentRepo repo;
	
	@Autowired
	public DepartmentService(DepartmentRepo repo) {
		this.repo = repo;
	}
	
	public List<Department> getAllDepartments() {
		return repo.findAll();
	}
	
	public Department createDepartment(Department department) {
		return repo.save(department);
	}
}
