package sg.edu.iss.team8.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team8.model.User;

public interface UserService {

	ArrayList<User> findAllUsers();

	User findUser(String username);

	User createUser(User user);

	User changeUser(User user);

	void removeUser(User user);

	/* (non-Javadoc)
	 * @see edu.iss.cats.service.UserService#findRoleNamesForUser(java.lang.String)
	 */
	/*
	@Transactional
	public ArrayList<String> findRoleNamesForUser(String userId) {
		ArrayList<Role> rset =  (ArrayList<Role>) userRepository.findOne(userId).getRoleSet();
		ArrayList<String> rnames = new ArrayList<String>();
		for (Role role : rset) {
			rnames.add(role.getName());
		}
		return rnames;
	}
	*/
	/* (non-Javadoc)
	 * @see edu.iss.cats.service.UserService#findManagerNameByUID(java.lang.String)
	 */
	/*
	@Transactional
	public ArrayList<String> findManagerNameByUID(String userId) {
		return userRepository.findManagerNameByUID(userId);
	}
	*/
	User authenticate(String username, String password);

}