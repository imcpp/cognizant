package com.cognizant.ormlearn.service;

import javax.transaction.Transactional;


import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Transactional
	public Department get(Integer id) {
		return departmentRepository.findById(id).get();
	}
	
	@Transactional
	public void save(Department department) {
		departmentRepository.save(department);
	}
}
