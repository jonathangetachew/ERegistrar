package edu.mum.se.eregistrar.repositories;

import edu.mum.se.eregistrar.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Jonathan on 10/9/2019.
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	@Query("select s from Student s where firstName like %:firstName%")
	Page<Student> findByFirstName(@Param("firstName") String firstName, Pageable pageable);
}
