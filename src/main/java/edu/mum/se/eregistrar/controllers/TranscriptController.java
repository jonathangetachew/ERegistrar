package edu.mum.se.eregistrar.controllers;

import edu.mum.se.eregistrar.services.TranscriptService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;

/**
 * Created by Jonathan on 10/9/2019.
 */

@Controller
public class TranscriptController {

	private final TranscriptService transcriptService;

	public TranscriptController(TranscriptService transcriptService) {
		this.transcriptService = transcriptService;
	}

	@GetMapping("/transcripts")
	public String getAllTranscripts(Model model) {
		model.addAttribute("transcripts", transcriptService.findAll());

		return "routes/transcripts";
	}

	@GetMapping("/transcripts/{id}")
	public String getTranscript(@PathVariable @Valid Long id, Model model) {
		model.addAttribute("transcript", transcriptService.findById(id));

		return "routes/transcript";
	}
}
