package studentinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class Studentservice {

	@Autowired
	StudentRep st;
	
	
	public List<Studentadmin> getlist()
	{
		return  (List<Studentadmin>) st.findAll();
	}
public boolean validateuser(Studentadmin studentadmin)
{
	boolean isvalid=false;
	Studentadmin adminobj=st.findbyCollateId(studentadmin.getName());
	if(adminobj!=null&&adminobj.getPassword().equals(studentadmin.getPassword()))
	{
		isvalid=true;
		
	}
		return isvalid;	
				
}
public void insert(Studentadmin studinsert)
{
	st.save(studinsert);
}

}
