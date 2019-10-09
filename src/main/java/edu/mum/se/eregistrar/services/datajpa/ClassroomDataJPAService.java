package edu.mum.se.eregistrar.services.datajpa;

import edu.mum.se.eregistrar.model.Classroom;
import edu.mum.se.eregistrar.repositories.ClassroomRepository;
import edu.mum.se.eregistrar.services.ClassroomService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jonathan on 10/9/2019.
 */

@Service
public class ClassroomDataJPAService implements ClassroomService {

	private final ClassroomRepository classroomRepository;

	public ClassroomDataJPAService(ClassroomRepository classroomRepository) {
		this.classroomRepository = classroomRepository;
	}

	@Override
	public List<Classroom> findAll() {
		return classroomRepository.findAll();
	}

	@Override
	public Classroom findById(Long id) {
		return classroomRepository.findById(id).orElse(null);
	}
}
