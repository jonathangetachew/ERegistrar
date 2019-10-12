package edu.mum.se.eregistrar.controllers;

import edu.mum.se.eregistrar.model.Classroom;
import edu.mum.se.eregistrar.services.ClassroomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
	public String getAllClassrooms(@RequestParam(defaultValue = "0") @Valid int pageNo, Model model) {
		model.addAttribute("classrooms", classroomService.findAll(pageNo));
		model.addAttribute("currentPageNo", pageNo);

		return "views/classroom/list";
	}

	@GetMapping("/classrooms/{id}")
	public String getClassroom(@PathVariable @Valid Long id, Model model) {
		model.addAttribute("classroom", classroomService.findById(id));

		return "views/classroom/detail";
	}

	@GetMapping("/classrooms/add")
	public String addClassroom(Model model) {
		model.addAttribute("classroom", new Classroom());
		return "views/classroom/add";
	}

	@GetMapping("/classrooms/{id}/edit")
	public String editClassroom(@PathVariable @Valid Long id, Model model) {
		model.addAttribute("classroom", classroomService.findById(id));
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
	 * @param classroom
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@PostMapping("/classrooms/add")
	public String addClassroom(@ModelAttribute Classroom classroom,
	                           BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "views/classroom/add";
		}

		classroom = classroomService.create(classroom);
		return "redirect:/classrooms/" + classroom.getId();
	}

	@PostMapping("/classrooms/{id}/edit")
	public String editClassroom(@Valid @ModelAttribute Classroom updatedClassroom,
	                               @PathVariable @Valid Long id,
	                               BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "views/classroom/edit";
		}
		Classroom classroom = classroomService.update(updatedClassroom, id);
		return "redirect:/classrooms/" + classroom.getId();
	}
}
