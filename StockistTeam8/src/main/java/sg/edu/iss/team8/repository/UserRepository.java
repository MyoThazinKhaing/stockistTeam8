package sg.edu.iss.team8.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.team8.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	/*@Query("SELECT u FROM User u WHERE u.username = :un")
	User findUserByUsername(@Param("un") String username);*/
	
	@Query("SELECT u FROM User u WHERE u.username=:un AND u.password=:pwd")
	User findUserByUsernamePwd(@Param("un") String username, @Param("pwd") String password);
	
	@Query("SELECT u FROM User u WHERE u.role=:role")
	ArrayList<User> findUserByRole(@Param("role") String role);
	
	@Query("SELECT DISTINCT u.role FROM User u")
	ArrayList<String> ListRoles();
	
	//Query for SEARCH
	@Query("SELECT u FROM User u WHERE u.role LIKE %:role%")
	ArrayList<User> searchUserByRole(@Param("role") String role);
	
	@Query("SELECT u FROM User u WHERE u.username LIKE %:un%")
	ArrayList<User> searchUserByUserName(@Param("un") String un);
	
	@Query("SELECT DISTINCT u.status FROM User u")
	ArrayList<String> ListStatus();
	
	@Query("SELECT u FROM User u WHERE u.status=:status")
	ArrayList<User> searchUserByStatus(@Param("status") String status);

}
