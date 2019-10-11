package edu.mum.se.eregistrar.services.datajpa;

import edu.mum.se.eregistrar.model.Student;
import edu.mum.se.eregistrar.repositories.StudentRepository;
import edu.mum.se.eregistrar.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jonathan on 10/9/2019.
 */

@Service
public class StudentDataJPAService implements StudentService {

	private final StudentRepository studentRepository;

	public StudentDataJPAService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteById(Long id) {
		studentRepository.deleteById(id);
	}
}
