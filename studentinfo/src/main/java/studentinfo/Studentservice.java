package studentinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


//We can use both @service and @component to specify the service..
@Component
public class Studentservice {

	@Autowired
	StudentadminRep st;
	
	@Autowired
	Studentinforep si;
	public List<Studentadmin> getlist()
	{
		return  (List<Studentadmin>)st.findAll();
	}
public boolean validateuser(Studentadmin studentadmin)
{
	boolean isvalid=false;
	Studentadmin adminobj=st.findbyCollateId(studentadmin.getName());
	if(adminobj!=null&&adminobj.getPassword().equals(studentadmin.getPassword()))
	{
		isvalid=true;
		//si.saveall(studentadmin.getName());
	}
	
		//si.post(studentadmin.getName());
	
		return isvalid;	

}
/*public void insert(String name)
{
	si.saveall(name);
	}*/

public void insert(Studentadmin studinsert)
{
	
	st.save(studinsert);
}
public List<Studentinfo> show()
{

	return (List<Studentinfo>) si.findAll();
}
public void insert(Studentinfo studinfo)
{
	si.save(studinfo);
	//si.saveall(studentadmin.);
}

}
