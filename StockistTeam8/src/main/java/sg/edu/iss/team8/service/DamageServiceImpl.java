package sg.edu.iss.team8.service;

import java.util.ArrayList;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import sg.edu.iss.team8.model.Damage;
import sg.edu.iss.team8.repository.DamageRepository;

@Service
public class DamageServiceImpl implements DamageService {
	
	
	@Resource 
	DamageRepository drepo;
	
	
	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.DamageService#findAllDamage()
	 */
	
	@Transactional
	public ArrayList<Damage> findAllDamage(){
		ArrayList<Damage> dlist=(ArrayList<Damage>) drepo.findAll();
		return dlist;
	}
	
	
	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.DamageService#findDamage(int)
	 */

	@Transactional
	public Damage findDamage(int id) {
		return drepo.findOne(id);
	}
	
	
	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.DamageService#changeDamage(sg.edu.iss.team8.model.Damage)
	 */
	
	@Transactional
	public Damage changeDamage(Damage d) {
		return drepo.saveAndFlush(d);
	}
	
	
	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.DamageService#createDamage(sg.edu.iss.team8.model.Damage)
	 */

	@Transactional
	public Damage createDamage(Damage d) {
		return drepo.saveAndFlush(d);
	}
	
	
	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.DamageService#removeDamage(sg.edu.iss.team8.model.Damage)
	 */
	
	@Transactional
	public void removeDamage(Damage d) {
		drepo.delete(d);
	}
	
	
	@Transactional
	public ArrayList<Damage> findCoursesByPNUM(int pnum) {
		return drepo.findCoursesByPNUM(pnum);
	}
	
	
	
}
