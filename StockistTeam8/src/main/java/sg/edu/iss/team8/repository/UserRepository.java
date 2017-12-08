package sg.edu.iss.team8.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.team8.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	/*@Query("SELECT DISTINCT e2.name FROM User u, Employee e1, Employee e2 WHERE u.employeeId = e1.employeeId AND e1.managerId = e2.employeeId AND u.userId=:uid")
	ArrayList<String> findManagerNameByUID(@Param("uid") String uid);
    
	@Query("SELECT u FROM User u WHERE u.name=:un AND u.password=:pwd")
	User findUserByNamePwd(@Param("un") String uname, @Param("pwd") String pwd);*/
	
	/*@Query("SELECT u FROM user u WHERE u.username = :un")
	User findUserByUsername(@Param("un") String username);
	
	@Query("SELECT u FROM User u WHERE u.username=:un AND u.password=:pwd")
	User findUserByUsernamePwd(@Param("un") String username, @Param("pwd") String password);
	
	@Query("SELECT u FROM User u WHERE u.role=:role")
	ArrayList<User> findUserByRole(@Param("role") String role);*/
}
