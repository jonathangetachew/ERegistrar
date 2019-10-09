package edu.mum.se.eregistrar.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
@EqualsAndHashCode
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "student_number")
	private Long studentNumber;

	@NotEmpty
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@NotEmpty
	@Column(name = "last_name")
	private String lastName;

	private Double cgpa;

	private LocalDate dateOfEnrollment;

	@OneToOne
	private Transcript transcript;

	@ManyToMany
	@JoinTable(name = "student_classroom",
			joinColumns = @JoinColumn(name = "student_id"),
			inverseJoinColumns = @JoinColumn(name = "classroom_id"))
	private List<Classroom> classrooms = new ArrayList<>();
}
