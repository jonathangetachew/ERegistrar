package edu.mum.se.eregistrar.repositories;

import edu.mum.se.eregistrar.model.Transcript;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Jonathan on 10/9/2019.
 */

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript, Long> {
	Page<Transcript> findByDegreeTitle(String degreeTitle, Pageable pageable);
}
