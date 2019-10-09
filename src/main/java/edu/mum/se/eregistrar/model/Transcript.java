package edu.mum.se.eregistrar.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Created by Jonathan on 10/9/2019.
 */

@Entity
@Table(name = "transcripts")
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Transcript {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name = "degree_title")
	private String degreeTitle;
}
