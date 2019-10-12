package edu.mum.se.eregistrar.services.datajpa;

import edu.mum.se.eregistrar.model.Student;
import edu.mum.se.eregistrar.repositories.StudentRepository;
import edu.mum.se.eregistrar.services.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
	public Page<Student> findAll(int pageNo) {
		return studentRepository.findAll(PageRequest.of(pageNo, 3, Sort.by("firstName")));
	}

	@Override
	public Student findById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public Page<Student> findStudentByFirstName(String firstName, int pageNo) {
		return studentRepository.findByFirstName(firstName, PageRequest.of(pageNo, 3, Sort.by("firstName")));
	}

	@Override
	public Student create(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student update(Student newStudent, Long id) {
		return studentRepository.findById(id)
			.map(student -> {
				student.setStudentNumber(newStudent.getStudentNumber());
				student.setFirstName(newStudent.getFirstName());
				student.setMiddleName(newStudent.getMiddleName());
				student.setLastName(newStudent.getLastName());
				student.setCgpa(newStudent.getCgpa());
				student.setDateOfEnrollment(newStudent.getDateOfEnrollment());
				student.setStudentType(newStudent.getStudentType());
				student.setTranscript(newStudent.getTranscript());
				student.setClassrooms(newStudent.getClassrooms());

				return studentRepository.save(student);
			}).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		studentRepository.deleteById(id);
	}
}
