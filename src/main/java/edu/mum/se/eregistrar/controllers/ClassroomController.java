package edu.mum.se.eregistrar.controllers;

import edu.mum.se.eregistrar.model.Classroom;
import edu.mum.se.eregistrar.services.ClassroomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * Created by Jonathan on 10/9/2019.
 */

@Controller
public class ClassroomController {

	private final ClassroomService classroomService;

	public ClassroomController(ClassroomService classroomService) {
		this.classroomService = classroomService;
	}

	/**
	 *
	 * Get Mappings
	 * @param model
	 * @return
	 */
	@GetMapping("/classrooms")
	public String getAllClassrooms(Model model) {
		model.addAttribute("classrooms", classroomService.findAll());

		return "views/classroom/list";
	}

	@GetMapping("/classrooms/{id}")
	public String getClassroom(@PathVariable @Valid Long id, Model model) {
		model.addAttribute("classroom", classroomService.findById(id));

		return "views/classroom/detail";
	}

	@GetMapping("/classrooms/add")
	public String addClassroom(@PathVariable @Valid Long id, Model model) {
		return "views/classroom/edit";
	}

	@GetMapping("/classrooms/{id}/delete")
	public String deleteClassroomById(@PathVariable @Valid Long id) {
		classroomService.deleteById(id);

		return "redirect:/classrooms";
	}
	/**
	 *
	 * Post Mappings
	 *
	 */
	@PostMapping("/classrooms/add")
	public String addClassroom(@ModelAttribute("newClassroom") Classroom classroom) {

		classroomService.save(classroom);

		return "redirect:/list";
	}
}
