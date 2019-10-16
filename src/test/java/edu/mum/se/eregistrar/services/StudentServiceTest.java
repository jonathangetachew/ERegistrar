package edu.mum.se.eregistrar.services;

import edu.mum.se.eregistrar.model.Student;
import edu.mum.se.eregistrar.repositories.StudentRepository;
import edu.mum.se.eregistrar.services.datajpa.StudentDataJPAService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class StudentServiceTest {

	StudentService studentService;

	@Mock
	StudentRepository studentRepository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);

		studentService = new StudentDataJPAService(studentRepository);
	}

	@Test
	void testFindAll() {
		//given
		Student student = new Student();
		student.setId(1L);
		Student student2 = new Student();
		student2.setId(2L);

		List<Student> students = Arrays.asList(student, student2);

		when(studentRepository.findAll(any(Pageable.class))).thenReturn((Page<Student>) students);

		//when
		Page<Student> studentsPage = studentService.findAll(0);

		//then
		assertEquals(1L, studentsPage.getTotalElements());
		verify(studentRepository, times(1)).findAll();
	}

	@Test
	void testFindById() {
	}

	@Test
	void testFindStudentByFirstName() {
	}

	@Test
	void testCreate() {
	}

	@Test
	void testUpdate() {
	}

	@Test
	void testDeleteById() {
	}
}