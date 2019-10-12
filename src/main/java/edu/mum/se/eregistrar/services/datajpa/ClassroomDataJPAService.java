package edu.mum.se.eregistrar.services.datajpa;

import edu.mum.se.eregistrar.model.Classroom;
import edu.mum.se.eregistrar.repositories.ClassroomRepository;
import edu.mum.se.eregistrar.services.ClassroomService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
	public Page<Classroom> findAll(int pageNo) {
		return classroomRepository.findAll(PageRequest.of(pageNo, 3, Sort.by("buildingName")));
	}

	@Override
	public Classroom findById(Long id) {
		return classroomRepository.findById(id).orElse(null);
	}

	@Override
	public Classroom create(Classroom classroom) {
		return classroomRepository.save(classroom);
	}

	@Override
	public Classroom update(Classroom newClassroom, Long id) {
		return classroomRepository.findById(id)
			.map(classroom -> {
				classroom.setBuildingName(newClassroom.getBuildingName());
				classroom.setRoomNumber(newClassroom.getRoomNumber());
				classroom.setStudents(newClassroom.getStudents());

				return classroomRepository.save(classroom);
			}).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		classroomRepository.deleteById(id);
	}
}
