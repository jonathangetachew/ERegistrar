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
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
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

		Student student3 = new Student();
		student3.setStudentNumber(1L);
		student3.setFirstName("Derrick");
		student3.setMiddleName("Martell");
		student3.setLastName("Rose");
		student3.setCgpa(3.20);
		student3.setDateOfEnrollment(LocalDate.now());
		student3.setStudentType(StudentType.INTERNATIONAL);

		///> Create Transcript
		Transcript transcript3 = new Transcript();
		transcript3.setDegreeTitle("Accounting");

		student3.setTranscript(transcript3);

		Student student4 = new Student();
		student4.setStudentNumber(3L);
		student4.setFirstName("Dwayne");
		student4.setMiddleName("Magician");
		student4.setLastName("Wade");
		student4.setCgpa(3.40);
		student4.setDateOfEnrollment(LocalDate.now());
		student4.setStudentType(StudentType.NATIONAL);

		///> Create Transcript
		Transcript transcript4 = new Transcript();
		transcript4.setDegreeTitle("Maharishi Vedic Science");

		student4.setTranscript(transcript4);

		Student student5 = new Student();
		student5.setStudentNumber(23L);
		student5.setFirstName("Lebron");
		student5.setMiddleName("King");
		student5.setLastName("James");
		student5.setCgpa(3.00);
		student5.setDateOfEnrollment(LocalDate.now());
		student5.setStudentType(StudentType.NATIONAL);

		///> Create Transcript
		Transcript transcript5 = new Transcript();
		transcript5.setDegreeTitle("Business");

		student5.setTranscript(transcript5);

		///> Create Classrooms
		Classroom classroom1 = new Classroom();
		classroom1.setBuildingName("McLaughlin Building");
		classroom1.setRoomNumber("M105");

		Classroom classroom2 = new Classroom();
		classroom2.setBuildingName("Library");
		classroom2.setRoomNumber("L209");

		Classroom classroom3 = new Classroom();
		classroom3.setBuildingName("Verhill");
		classroom3.setRoomNumber("V32");

		Classroom classroom4 = new Classroom();
		classroom4.setBuildingName("Drier");
		classroom4.setRoomNumber("D20");

		Classroom classroom5 = new Classroom();
		classroom5.setBuildingName("Veda Bhavan");
		classroom5.setRoomNumber("D20");

		student1.getClassrooms().addAll(Arrays.asList(classroom1, classroom2));
		student2.getClassrooms().addAll(Arrays.asList(classroom1, classroom2));
		student3.getClassrooms().addAll(Arrays.asList(classroom3));
		student4.getClassrooms().addAll(Arrays.asList(classroom5));
		student5.getClassrooms().addAll(Arrays.asList(classroom4));

		///> Save Data to DB
		classroomRepository.saveAll(Arrays.asList(classroom1, classroom2, classroom3, classroom4, classroom5));
		studentRepository.saveAll(Arrays.asList(student1, student2, student3, student4, student5));

	}
}
