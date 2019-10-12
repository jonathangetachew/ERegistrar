package edu.mum.se.eregistrar.services;

import edu.mum.se.eregistrar.model.Student;
import org.springframework.data.domain.Page;

/**
 * Created by Jonathan on 10/9/2019.
 */

public interface StudentService extends CrudService<Student, Long> {
	Page<Student> findStudentByFirstName(String firstName, int pageNo);
}
