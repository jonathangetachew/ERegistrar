package edu.mum.se.eregistrar.services;

import edu.mum.se.eregistrar.model.Classroom;
import org.springframework.data.domain.Page;

/**
 * Created by Jonathan on 10/9/2019.
 */

public interface ClassroomService extends CrudService<Classroom, Long> {
	Page<Classroom> findClassroomByBuildingName(String buildingName, int pageNo);
}
