package edu.mum.se.eregistrar.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan on 10/9/2019.
 */

@Entity
@Table(name = "classrooms")
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Classroom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "building_name")
	private String buildingName;

	@Column(name = "room_number")
	private String roomNumber;

	@ManyToMany(mappedBy = "classrooms", cascade = CascadeType.ALL)
	private List<Student> students = new ArrayList<>();
}
