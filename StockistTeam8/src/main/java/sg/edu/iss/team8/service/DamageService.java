package sg.edu.iss.team8.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team8.model.Damage;

public interface DamageService {

	ArrayList<Damage> findAllDamage();

	Damage findDamage(int id);

	Damage changeDamage(Damage d);

	Damage createDamage(Damage d);

	void removeDamage(Damage d);
	
	

	ArrayList<Damage> findCoursesByPNUM(int pnum);

}