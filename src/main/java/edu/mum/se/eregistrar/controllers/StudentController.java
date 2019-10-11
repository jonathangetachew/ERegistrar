package edu.mum.se.eregistrar.controllers;

import edu.mum.se.eregistrar.model.Student;
import edu.mum.se.eregistrar.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * Created by Jonathan on 10/9/2019.
 */

@Controller
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("students", studentService.findAll());

		return "views/student/list";
	}

	@GetMapping("/students/{id}")
	public String getStudent(@PathVariable @Valid Long id, Model model) {
		model.addAttribute("student", studentService.findById(id));

		return "views/student/detail";
	}

	@GetMapping("/students/add")
	public String addNewTranscript(Model model) {
		model.addAttribute("student", new Student());
		return "views/student/add";
	}

	@GetMapping("/students/{id}/delete")
	public String deleteStudentById(@PathVariable @Valid Long id) {
		studentService.deleteById(id);

		return "redirect:/students";
	}

	/**
	 *
	 * Post Mappings
	 *
	 * @param student
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@PostMapping("/students/add")
	public String addNewTranscript(@Valid @ModelAttribute("student") Student student,
	                               BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "views/students/add";
		}
		student = studentService.save(student);
		return "redirect:/students/" + student.getId();
	}
}
