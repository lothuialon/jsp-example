package com.lothuialon.jspexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lothuialon.jspexample.entity.Project;

public interface ProjectRepository extends JpaRepository<Project,Long> {

	
	
}
