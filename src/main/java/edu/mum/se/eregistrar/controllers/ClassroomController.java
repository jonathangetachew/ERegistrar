package edu.mum.se.eregistrar.controllers;

import edu.mum.se.eregistrar.services.ClassroomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

	@GetMapping("/classrooms")
	public String getAllTranscripts(Model model) {
		model.addAttribute("transcripts", classroomService.findAll());

		return "routes/classrooms";
	}

	@GetMapping("/classrooms/{id}")
	public String getTranscript(@PathVariable @Valid Long id, Model model) {
		model.addAttribute("transcript", classroomService.findById(id));

		return "routes/classroom";
	}
}
