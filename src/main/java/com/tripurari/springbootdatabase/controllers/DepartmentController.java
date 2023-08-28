package com.tripurari.springbootdatabase.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripurari.springbootdatabase.models.Department;
import com.tripurari.springbootdatabase.services.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	private final DepartmentService departmentService;
	
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@GetMapping
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}
	
	@PostMapping
	public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
		Department savedDepartment = departmentService.createDepartment(department);
		return ResponseEntity.ok(savedDepartment);
	}

}
