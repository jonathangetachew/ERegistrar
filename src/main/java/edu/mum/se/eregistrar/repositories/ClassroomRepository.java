package edu.mum.se.eregistrar.repositories;

import edu.mum.se.eregistrar.model.Classroom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Jonathan on 10/9/2019.
 */

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
	@Query("select c from Classroom c where buildingName like %:buildingName%")
	Page<Classroom> findByBuildingName(@Param("buildingName") String buildingName, Pageable pageable);
}
