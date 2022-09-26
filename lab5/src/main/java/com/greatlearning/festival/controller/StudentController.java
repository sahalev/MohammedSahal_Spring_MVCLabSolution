package com.greatlearning.festival.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.festival.dao.StudentDAO;
import com.greatlearning.festival.entity.Student;

@Controller
@RequestMapping("students")
public class StudentController {
	
	@Autowired
	StudentDAO studentDAO;
	
	@GetMapping("list")
	public String showStudents(Model model)
	{
		List<Student> students=studentDAO.findAll();
		model.addAttribute("students", students);
		return "studentlist";
	}
	
	
	@GetMapping("showForm")
	public String showStudentForm(Model model)
	{
		Student st = new Student();
		model.addAttribute("student", st);
		return "studentForm";
	}
	

	@PostMapping("save")
	public String saveStudent(Model model, @ModelAttribute("student") Student student)
	{
		studentDAO.saveStudent(student);
		return "redirect:/students/list";
	}
	
	@GetMapping("edit")
	public String updateStudent(Model model, @RequestParam("id") int id)
	{
		Student st = studentDAO.findById(id);
		model.addAttribute("student", st);
		return "studentForm";
	}
	
	@GetMapping("delete")
	public String deleteStudent(Model model, @RequestParam("id") int id)
	{
		studentDAO.deleteStudent(id);
		return "redirect:/students/list";
	}

}