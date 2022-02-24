package studentinfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Studentinfo")
@Table(name="studdet")
public class Studentinfo {
	
	int id;
	String name;
	String admin;
	Studentinfo()
	{
		
	}

Studentinfo(int id,String name,String admin)
{
	this.id=id;
	this.name=name;
	this.admin=admin;
}
@Id
@Column(name="id")
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
@Column(name="name")
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAdmin() {
	return admin;
}

public void setAdmin(String admin) {
	this.admin = admin;
}


}
