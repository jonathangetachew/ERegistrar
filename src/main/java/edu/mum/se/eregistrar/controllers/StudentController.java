package edu.mum.se.eregistrar.controllers;

import edu.mum.se.eregistrar.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	public String getAllTranscripts(Model model) {
		model.addAttribute("transcripts", studentService.findAll());

		return "routes/student";
	}

	@GetMapping("/students/{id}")
	public String getTranscript(@PathVariable @Valid Long id, Model model) {
		model.addAttribute("transcript", studentService.findById(id));

		return "routes/student";
	}
}
