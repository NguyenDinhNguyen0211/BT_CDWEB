package btgk.ltw.springboot.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
public class User {
	private String username;
	private String password;
	private String email;
	private Date joinDate;

	public User(String username, String password, String email,
			Date joinDate) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.joinDate = joinDate;
	}
	
	
}
