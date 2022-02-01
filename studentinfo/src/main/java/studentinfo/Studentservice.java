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


}
