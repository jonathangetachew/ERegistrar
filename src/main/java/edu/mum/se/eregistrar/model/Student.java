package edu.mum.se.eregistrar.model;

import edu.mum.se.eregistrar.enums.StudentType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan on 10/9/2019.
 */

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"transcript", "classrooms"})
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Student Number is Required")
	@Column(name = "student_number", nullable = false)
	private Long studentNumber;

	@NotBlank(message = "First Name is Required")
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@NotBlank(message = "Last Name is Required")
	@Column(name = "last_name", nullable = false)
	private String lastName;

	private Double cgpa;

	@NotNull(message = "Date of Enrollment is Required")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfEnrollment;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "student_type", nullable = false)
	private StudentType studentType;

	@OneToOne(cascade = CascadeType.ALL)
	private Transcript transcript;

	@ManyToMany
	@JoinTable(name = "student_classroom",
			joinColumns = @JoinColumn(name = "student_id"),
			inverseJoinColumns = @JoinColumn(name = "classroom_id"))
	private List<Classroom> classrooms = new ArrayList<>();

	///> Custom Setter
	public void setTranscript(Transcript transcript) {
		if (transcript != null) {
			this.transcript = transcript;
			transcript.setStudent(this);
		}
	}

	public Student addClassroom(Classroom classroom) {
		List<Student> students = classroom.getStudents();
		students.add(this);
		classroom.setStudents(students);

		this.classrooms.add(classroom);
		return this;
	}
}
