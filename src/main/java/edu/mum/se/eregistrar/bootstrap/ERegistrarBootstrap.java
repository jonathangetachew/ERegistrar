package edu.mum.se.eregistrar.bootstrap;

import edu.mum.se.eregistrar.enums.StudentType;
import edu.mum.se.eregistrar.model.Classroom;
import edu.mum.se.eregistrar.model.Student;
import edu.mum.se.eregistrar.model.Transcript;
import edu.mum.se.eregistrar.repositories.ClassroomRepository;
import edu.mum.se.eregistrar.repositories.StudentRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * Created by Jonathan on 10/9/2019.
 */

@Component
public class ERegistrarBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private final StudentRepository studentRepository;

	private final ClassroomRepository classroomRepository;

	public ERegistrarBootstrap(StudentRepository studentRepository, ClassroomRepository classroomRepository) {
		this.studentRepository = studentRepository;
		this.classroomRepository = classroomRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		loadData();
	}

	private void loadData() {

		///> Create Students
		Student student1 = new Student();
		student1.setStudentNumber(1L);
		student1.setFirstName("Luke");
		student1.setMiddleName("John");
		student1.setLastName("Cage");
		student1.setCgpa(3.90);
		student1.setDateOfEnrollment(LocalDate.now());
		student1.setStudentType(StudentType.INTERNATIONAL);

		///> Create Transcript
		Transcript transcript1 = new Transcript();
		transcript1.setDegreeTitle("BS Computer Science");

		student1.setTranscript(transcript1);

		Student student2 = new Student();
		student2.setStudentNumber(2L);
		student2.setFirstName("Jessica");
		student2.setMiddleName("Jane");
		student2.setLastName("Jones");
		student2.setCgpa(3.85);
		student2.setDateOfEnrollment(LocalDate.now());
		student2.setStudentType(StudentType.NATIONAL);

		///> Create Transcript
		Transcript transcript2 = new Transcript();
		transcript2.setDegreeTitle("BS Engineering");

		student2.setTranscript(transcript2);

		///> Create Classrooms
		Classroom classroom1 = new Classroom();
		classroom1.setBuildingName("McLaughlin Building");
		classroom1.setRoomNumber("M105");

		Classroom classroom2 = new Classroom();
		classroom2.setBuildingName("Library");
		classroom2.setRoomNumber("L209");

		student1.getClassrooms().addAll(Arrays.asList(classroom1, classroom2));
		student2.getClassrooms().addAll(Arrays.asList(classroom1, classroom2));

		///> Save Data to DB
		classroomRepository.saveAll(Arrays.asList(classroom1, classroom2));
		studentRepository.saveAll(Arrays.asList(student1, student2));

	}
}
