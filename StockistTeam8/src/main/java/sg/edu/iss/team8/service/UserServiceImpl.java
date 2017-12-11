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
	
	@Override
	@Transactional
	public ArrayList<User> findAllUsers() {
		ArrayList<User> ul = (ArrayList<User>) userRepository.findAll();
		return ul;
	}
	
	@Override
	@Transactional
	public User findUser(String username) {
		return userRepository.findOne(username);

	}

	@Override
	@Transactional
	public User createUser(User user) {
		return userRepository.saveAndFlush(user);
	}

	@Override
	@Transactional
	public User changeUser(User user) {
		return userRepository.saveAndFlush(user);
	}

	@Override
	@Transactional
	public void removeUser(User user) {
		userRepository.delete(user);
	}
	
	@Override
	@Transactional
	public User authenticate(String username, String password) {
		User u = userRepository.findUserByUsernamePwd(username, password);
		return u;
	}

}
