package edu.mum.se.eregistrar.controllers;

import edu.mum.se.eregistrar.model.Classroom;
import edu.mum.se.eregistrar.model.Student;
import edu.mum.se.eregistrar.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
	public String getAllStudents(@RequestParam(defaultValue = "0") @Valid int pageNo, Model model) {
		model.addAttribute("students", studentService.findAll(pageNo));
		model.addAttribute("currentPageNo", pageNo);

		return "views/student/list";
	}

	@GetMapping("/students/search")
	public String getStudentsByFirstName(@RequestParam("keyword") @Valid String keyword,
                                         @RequestParam(defaultValue = "0") @Valid int pageNo,
                                         Model model) {
		model.addAttribute("students", studentService.findStudentByFirstName(keyword, pageNo));
		model.addAttribute("currentPageNo", pageNo);

		return "views/student/search";
	}

	@GetMapping("/students/{id}")
	public String getStudent(@PathVariable @Valid Long id, Model model) {
		model.addAttribute("student", studentService.findById(id));

		return "views/student/detail";
	}

	@GetMapping("/students/add")
	public String addNewStudent(Model model) {
		model.addAttribute("student", new Student());
		return "views/student/add";
	}

	@GetMapping("/students/{id}/edit")
	public String addNewTranscript(@PathVariable @Valid Long id, Model model) {
		model.addAttribute("student", studentService.findById(id));
		return "views/student/edit";
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
	public String addNewStudent(@Valid @ModelAttribute Student student,
	                               BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "views/students/add";
		}
		student = studentService.create(student);
		return "redirect:/students/" + student.getId();
	}

	@PostMapping("/students/{id}/edit")
	public String editStudent(@Valid @ModelAttribute Student updatedStudent,
	                            @PathVariable @Valid Long id,
	                            BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "views/student/edit";
		}
		Student student = studentService.update(updatedStudent, id);
		return "redirect:/students/" + student.getId();
	}
}
