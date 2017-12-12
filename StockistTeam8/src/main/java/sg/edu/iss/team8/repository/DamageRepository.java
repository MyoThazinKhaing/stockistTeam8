package sg.edu.iss.team8.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import sg.edu.iss.team8.model.Damage;

public interface DamageRepository extends JpaRepository<Damage, Integer> {
	
	
	@Query("SELECT d from Damage d WHERE d.partNumber = :pnum")
	ArrayList<Damage> findCoursesByPNUM(@Param("pnum") int pnum);
	
	
}

