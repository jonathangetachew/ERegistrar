package edu.mum.se.eregistrar.controllers;

import edu.mum.se.eregistrar.model.Transcript;
import edu.mum.se.eregistrar.services.TranscriptService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

	/**
	 *
	 * Get Mappings
	 *
	 * @param pageNo
	 * @param model
	 * @return
	 */
	@GetMapping("/transcripts")
	public String getAllTranscripts(@RequestParam(defaultValue = "0") @Valid int pageNo, Model model) {
		model.addAttribute("transcripts", transcriptService.findAll(pageNo));
		model.addAttribute("currentPageNo", pageNo);

		return "views/transcript/list";
	}

	@GetMapping("/transcripts/search")
	public String getTranscriptByDegreeTitle(@RequestParam("keyword") @Valid String keyword,
	                                         @RequestParam(defaultValue = "0") @Valid int pageNo,
	                                         Model model) {
		model.addAttribute("transcripts", transcriptService.findTranscriptByDegreeTitle(keyword, pageNo));
		model.addAttribute("currentPageNo", pageNo);

		return "views/transcript/search";
	}

	@GetMapping("/transcripts/{id}")
	public String getTranscript(@PathVariable @Valid Long id, Model model) {
		model.addAttribute("transcript", transcriptService.findById(id));

		return "views/transcript/detail";
	}

	@GetMapping("/transcripts/add")
	public String addNewTranscript(Model model) {
		model.addAttribute("transcript", new Transcript());
		return "views/transcript/add";
	}

	@GetMapping("/transcripts/{id}/edit")
	public String editTranscript(@PathVariable @Valid Long id, Model model) {
		model.addAttribute("transcript", transcriptService.findById(id));
		return "views/transcript/edit";
	}

	@GetMapping("/transcripts/{id}/delete")
	public String deleteTranscriptById(@PathVariable @Valid Long id) {
		transcriptService.deleteById(id);

		return "redirect:/transcripts";
	}

	/**
	 *
	 * Post Mappings
	 *
	 * @param transcript
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@PostMapping("/transcripts/add")
	public String addNewTranscript(@Valid @ModelAttribute Transcript transcript,
	                         BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "views/transcript/add";
		}
		transcript = transcriptService.create(transcript);
		return "redirect:/transcripts/" + transcript.getId();
	}

	@PostMapping("/transcripts/{id}/edit")
	public String editTranscript(@Valid @ModelAttribute Transcript updatedTranscript,
	                         @PathVariable @Valid Long id,
	                         BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "views/transcript/edit";
		}
		Transcript transcript = transcriptService.update(updatedTranscript, id);
		return "redirect:/transcripts/" + transcript.getId();
	}

}
