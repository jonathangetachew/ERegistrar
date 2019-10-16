package edu.mum.se.eregistrar.controllers;

import edu.mum.se.eregistrar.services.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class StudentControllerTest {

	@Autowired
	MockMvc mockMvc;

	@BeforeEach
	void setUp() {
	}

	@Test
	void getAllStudents() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(view().name("view/student/list"));
	}

	@Test
	void getStudentsByFirstName() {
	}

	@Test
	void getStudent() {
	}

	@Test
	void addNewStudent() {
	}

	@Test
	void addNewTranscript() {
	}

	@Test
	void deleteStudentById() {
	}

	@Test
	void testAddNewStudent() {
	}

	@Test
	void editStudent() {
	}
}