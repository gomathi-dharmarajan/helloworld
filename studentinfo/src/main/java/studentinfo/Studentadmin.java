package studentinfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


//@entity defines this Studentadmin class as a table..
@Entity(name="Studentadmin")
//@Table is used to specify the table name..
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
//@id is mandatory and it must be declared before a primary key column
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
