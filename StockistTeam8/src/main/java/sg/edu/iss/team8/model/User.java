package sg.edu.iss.team8.model;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name = "username")
	private String userName;
	@Basic(optional = false)
	@Column(name = "password")
	private String password;
	@Column(name = "role")
	private String role;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String userName, String password, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
	