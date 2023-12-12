package com.lothuialon.jspexample.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lothuialon.jspexample.entity.Project;
import com.lothuialon.jspexample.service.impl.ProjectServiceImpl;

@Controller
public class ProjectController {
	
	private final ProjectServiceImpl projectServiceImpl;
	
	
	public ProjectController(ProjectServiceImpl projectServiceImpl)
	{
	this.projectServiceImpl = projectServiceImpl;
	}
	
	@RequestMapping(value="/allprojects2",method=RequestMethod.GET)
	public ResponseEntity<List<Project>> getData2() {
		List<Project> liste = projectServiceImpl.getAll();
		
		//return new ResponseEntity<>(liste,HttpStatus.OK);
		return ResponseEntity.ok(liste);
	}
	
	@RequestMapping(value="/allprojects",method=RequestMethod.GET)
	public ModelAndView getData() {
		List<Project> liste = projectServiceImpl.getAll();
		ModelAndView model = new ModelAndView("projects");
		model.addObject("projeListesi",liste);
		return model;
	}
	
	
	@RequestMapping(value="/editproject/{id}")
	public String editProj(@PathVariable Long id, Model m) {
		Project projectDetay = projectServiceImpl.getById(id);
		m.addAttribute("command",projectDetay);
		return "editproject";
	}
	
	@RequestMapping("/newproject")
	public ModelAndView showForm() 
	{
		return new ModelAndView("newproject","command",new Project());
	}
	
	@RequestMapping(value="/addNewProject",method=RequestMethod.POST)
	public ModelAndView kaydet(@ModelAttribute("project")Project project,
			BindingResult result, ModelMap model)
	{
		Date date = new Date();
		project.setInsertDate(date);
		projectServiceImpl.save(project);
		return new ModelAndView("redirect:allprojects");
	}
	
	@PostMapping("/allprojects2")
	public ResponseEntity<Project> createProject(@RequestBody Project project)
	{
		try
		{
			Project projectNew = projectServiceImpl.save(project);
			return new ResponseEntity<>(projectNew,HttpStatus.CREATED);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/editsave", method=RequestMethod.POST)
	public String projeGuncelle(@ModelAttribute("project")Project project) {
		projectServiceImpl.update(project);
		return "redirect:allprojects";
	}
	
	
}
