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
	/*default constructor is must.. If we dont create it, it will throw runtime exception
	 * Default constructor is missing..
	 */
	public Studentadmin() {
		
	}
	public Studentadmin(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	/*@id is mandatory and it must be declared before a primary key column. If we omit it, it will throw beancreationException
	error creating bean with name 'entitymanagerfactory'.. We can have it before any of the column*/

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
