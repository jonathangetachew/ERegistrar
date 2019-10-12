package edu.mum.se.eregistrar.services;

import edu.mum.se.eregistrar.model.Transcript;
import org.springframework.data.domain.Page;

/**
 * Created by Jonathan on 10/9/2019.
 */

public interface TranscriptService extends CrudService<Transcript, Long> {
	Page<Transcript> findTranscriptByDegreeTitle(String degreeTitle, int pageNo);
}
