package studentinfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Studentadmin")
@Table(name="admin")

public class Studentadmin {
	
	private String name;
	private String password;
	public Studentadmin() {
		
	}
	public Studentadmin(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
@Id
	@Column(name="name",nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="password" ,nullable=false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
