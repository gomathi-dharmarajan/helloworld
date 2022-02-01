package studentinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("student")
public class StudController {
	
	@Autowired
	Studentservice sr;
	@GetMapping(path="/Admin")
	public List<Studentadmin> getlist()
	{
		return sr.getlist();
	}

}
