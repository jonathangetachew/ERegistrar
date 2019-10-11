package edu.mum.se.eregistrar.services.datajpa;

import edu.mum.se.eregistrar.model.Transcript;
import edu.mum.se.eregistrar.repositories.TranscriptRepository;
import edu.mum.se.eregistrar.services.TranscriptService;
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
	public List<Transcript> findAll() {
		return transcriptRepository.findAll();
	}

	@Override
	public Transcript findById(Long id) {
		return transcriptRepository.findById(id).orElse(null);
	}

	@Override
	public Transcript save(Transcript transcript) {
		return transcriptRepository.save(transcript);
	}

	@Override
	public void deleteById(Long id) {
		transcriptRepository.deleteById(id);
	}
}
