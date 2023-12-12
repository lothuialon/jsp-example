package com.lothuialon.jspexample.service;

import java.util.List;

import com.lothuialon.jspexample.entity.Project;

public interface ProjectService {
	
	List<Project> getAll();
	
	Project getById(Long id);
	
	Project save(Project project);
	
	Project update(Project project);
	
	Boolean delete(Long id);

}
