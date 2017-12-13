package sg.edu.iss.team8.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team8.model.User;
import sg.edu.iss.team8.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;
	
	private final String[] STATUS = { "active", "inactive" };

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.iss.cats.service.UserService#findAllUsers()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see sg.edu.iss.team8.service.UserService#findAllUsers()
	 */
	@Override
	@Transactional
	public ArrayList<User> findAllUsers() {
		ArrayList<User> ul = (ArrayList<User>) userRepository.findAll();
		return ul;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.iss.cats.service.UserService#findUser(java.lang.String)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see sg.edu.iss.team8.service.UserService#findUser(java.lang.String)
	 */
	@Override
	@Transactional
	public User findUser(String username) {
		return userRepository.findOne(username);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.iss.cats.service.UserService#createUser(edu.iss.cats.model.User)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sg.edu.iss.team8.service.UserService#createUser(sg.edu.iss.team8.model.User)
	 */
	@Override
	@Transactional
	public User createUser(User user) {
		return userRepository.saveAndFlush(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.iss.cats.service.UserService#changeUser(edu.iss.cats.model.User)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sg.edu.iss.team8.service.UserService#changeUser(sg.edu.iss.team8.model.User)
	 */
	@Override
	@Transactional
	public User changeUser(User user) {
		return userRepository.saveAndFlush(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.iss.cats.service.UserService#removeUser(edu.iss.cats.model.User)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sg.edu.iss.team8.service.UserService#removeUser(sg.edu.iss.team8.model.User)
	 */
	@Override
	@Transactional
	public void removeUser(User user) {
		userRepository.delete(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.iss.cats.service.UserService#findRolesForUser(java.lang.String)
	 */

	/*
	 * @Transactional public ArrayList<Role> findRolesForUser(String userId) {
	 * return (ArrayList<Role>)userRepository.findOne(userId).getRoleSet(); }
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.iss.cats.service.UserService#findRoleNamesForUser(java.lang.String)
	 */
	/*
	 * @Transactional public ArrayList<String> findRoleNamesForUser(String userId) {
	 * ArrayList<Role> rset = (ArrayList<Role>)
	 * userRepository.findOne(userId).getRoleSet(); ArrayList<String> rnames = new
	 * ArrayList<String>(); for (Role role : rset) { rnames.add(role.getName()); }
	 * return rnames; }
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.iss.cats.service.UserService#findManagerNameByUID(java.lang.String)
	 */
	/*
	 * @Transactional public ArrayList<String> findManagerNameByUID(String userId) {
	 * return userRepository.findManagerNameByUID(userId); }
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see sg.edu.iss.team8.service.UserService#authenticate(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	@Transactional
	public User authenticate(String username, String password) {
		User u = userRepository.findUserByUsernamePwd(username, password);
		return u;
	}

	@Override
	@Transactional
	public ArrayList<String> ListRoles() {
		return userRepository.ListRoles();

	}

	@Override
	public ArrayList<User> searchUsers(String criteria, String description) {
		ArrayList<User> userList = new ArrayList<>();
		switch (criteria) {
		case "username": userList = userRepository.searchUserByUserName(description);
		break;
		case "role": userList = userRepository.searchUserByRole(description);
		break;
		case "status": userList = userRepository.searchUserByStatus(description);
		break;
		default: userList = null;
		break;
		}
		return userList;
		
	}
	
	@Override
	public String[] ListStatus() {
		return STATUS;
	}

}
