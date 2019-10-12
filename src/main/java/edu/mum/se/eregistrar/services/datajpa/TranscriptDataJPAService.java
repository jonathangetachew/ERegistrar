package edu.mum.se.eregistrar.services.datajpa;

import edu.mum.se.eregistrar.model.Transcript;
import edu.mum.se.eregistrar.repositories.TranscriptRepository;
import edu.mum.se.eregistrar.services.TranscriptService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jonathan on 10/9/2019.
 */

@Service
public class TranscriptDataJPAService implements TranscriptService {

	private final TranscriptRepository transcriptRepository;

	public TranscriptDataJPAService(TranscriptRepository transcriptRepository) {
		this.transcriptRepository = transcriptRepository;
	}

	@Override
	public Page<Transcript> findAll(int pageNo) {
		return transcriptRepository.findAll(PageRequest.of(pageNo, 3, Sort.by("degreeTitle")));
	}

	@Override
	public Transcript findById(Long id) {
		return transcriptRepository.findById(id).orElse(null);
	}

	@Override
	public Page<Transcript> findTranscriptByDegreeTitle(String degreeTitle, int pageNo) {
		return transcriptRepository.findByDegreeTitle(degreeTitle, PageRequest.of(pageNo, 3, Sort.by("degreeTitle")));
	}

	@Override
	public Transcript create(Transcript transcript) {
		return transcriptRepository.save(transcript);
	}

	public Transcript update(Transcript newTranscript, Long id) {
		return transcriptRepository.findById(id)
				.map(transcript -> {
					transcript.setDegreeTitle(newTranscript.getDegreeTitle());
					transcript.setStudent(newTranscript.getStudent());

					return transcriptRepository.save(transcript);
				}).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		transcriptRepository.deleteById(id);
	}
}
