package com.lothuialon.jspexample.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lothuialon.jspexample.entity.Project;
import com.lothuialon.jspexample.repository.ProjectRepository;
import com.lothuialon.jspexample.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	private final ProjectRepository projectRepository;
	
	public ProjectServiceImpl(ProjectRepository projectRepository)
	{
		this.projectRepository = projectRepository;
	}
	
	@Override
	public List<Project> getAll() {
		//select * from Project
		List<Project> projectList = projectRepository.findAll();
		return projectList;
	}

	@Override
	public Project getById(Long id) {
		//Project project = projectRepository.findById(id).orElseThrow();
		// select * from Project where Id=id
		Project project = projectRepository.getOne(id);
		return project;
	}

	@Override
	public Project save(Project project) {
        if(project.getProjectCode()==null)
        {
        	throw new IllegalArgumentException("hatalı kayıt");
        }
        //insert into Project(ProjectName,ProjectCode) values(project.getProject)
       Project projectDb= projectRepository.save(project);
		
		return projectDb;
	}

	@Override
	public Project update(Project project) {
		//güncellenecek olan kaydı bul getir
		Project projectDb = projectRepository.getOne(project.getId());
		if(projectDb==null)
		{
			throw new IllegalArgumentException("ilgili kayıt bulunamadı");
		}
		projectDb.setProjectCode(project.getProjectCode());
		projectDb.setProjectName(project.getProjectName());
		projectDb.setInsertDate(new Date());
		Project projectUpd = projectRepository.save(projectDb);
		
		return projectUpd;
	}

	@Override
	public Boolean delete(Long id) {
		projectRepository.deleteById(id);
		return true;
	}

}
