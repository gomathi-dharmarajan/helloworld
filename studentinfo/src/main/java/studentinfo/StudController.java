package studentinfo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


//@RestController annotation indicates that the annotated class is a controller. used in rest web services.
//If we use @ controller it will throw 404 error.. in rest webservices we should use @RestController..
@RestController

@RequestMapping("student")
public class StudController {
	private static final Logger log=LoggerFactory.getLogger(StudController.class);
	
	
	//If we dont use @Autowired it will throw NullPointerException.. @Autowired is used to inject the service..
	//Dependency injection..
	@Autowired
	Studentservice sr;
	
	//used to get values from the table..
	@GetMapping(path="/Admin")
	public List<Studentadmin> getlist()
	{
		log.info("getting the list of studentadmin");
		return sr.getlist();
	}
	
	
	//used to insert values to the table..
	@PostMapping(path="/validate",consumes =MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	
public ResponseEntity<String> validateuser(@RequestBody String studentadmin) throws JsonProcessingException

{
	Studentadmin studadmin=(Studentadmin)new ObjectMapper().readValue(studentadmin,Studentadmin.class);
	boolean isvalid=sr.validateuser(studadmin);
	log.info("validating user");
	return new ResponseEntity<>(getResponseStr(isvalid+""),HttpStatus.OK);
	
}
	@PostMapping("/insert")
	//@requestbody is used to convert HTTPRequest to object
	public ResponseEntity<String> insert(@RequestBody String admininsert) throws JsonProcessingException
	
	{
		//Reading java objects from json. admininsert is a json string. It is mapped to Studentadmin class and then created
		//as a java object.
		Studentadmin admin=new ObjectMapper().readValue(admininsert, Studentadmin.class);
		log.info("inserting admin list");
		sr.insert(admin);
		return new ResponseEntity<>("Success",HttpStatus.OK);
		
	}
	public String getResponseStr(String resp) {
        return "Webservice_Response" + resp;
    }


}
