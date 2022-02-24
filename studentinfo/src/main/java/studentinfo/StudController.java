package studentinfo;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


//@RestController annotation indicates that the annotated class is a controller. used in rest web services.
//If we use @ controller it will throw 404 error.. in rest webservices we should use @RestController..
//It will display the output in JSON format.
@RestController

@RequestMapping("student")
public class StudController {
	private static final Logger log=LoggerFactory.getLogger(StudController.class);
	
	
	//If we dont use @Autowired it will throw NullPointerException.. @Autowired is used to inject the service..
	//Dependency injection.. loosely coupled..
	@Autowired
	Studentservice sr;
	
	
	@GetMapping(path="/Student")
	public List<Studentinfo> getStudent()
	{
		return sr.show();
	}
	
	//used to get values from the table..
	@GetMapping(path="/Admin")
	public List<Studentadmin> getlist()
	{
		log.info("getting the list of studentadmin");
		return sr.getlist();
	}
	
	
	//used to insert values to the table..
	@PostMapping(path="/validate",consumes =MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	
public ResponseEntity<Boolean> validateuser(@RequestBody String studentadmin) throws JsonProcessingException

{
		RestTemplate rs=new RestTemplate();
	Studentadmin studadmin=new ObjectMapper().readValue(studentadmin,Studentadmin.class);
	boolean isvalid=sr.validateuser(studadmin);
	log.info("validating user");
	//sr.insert(studadmin.getName());


	return new ResponseEntity<>(isvalid,HttpStatus.OK);
	
}
	@PostMapping("/insert")
//@requestbody tells to spring to bound this annotated parameter to the body of the request..the body is expected
	//to be of JSON format.. Iif we dont give @request body illegalargument exception will be thrown internal server error 500
	public ResponseEntity<String> insert(@RequestBody String admininsert) throws JsonProcessingException
	
	{
		//Converting JSon string to java object.. admininsert is a json string. It is mapped to Studentadmin class and then created
		//as a java object. Deserialize json to java.. It is a part of jackson library..
		Studentadmin admin=new ObjectMapper().readValue(admininsert, Studentadmin.class);
		log.info("inserting admin list");
		sr.insert(admin);
		return new ResponseEntity<>("Record inserted successfully",HttpStatus.OK);
		
	}
	@PostMapping("/insertstudinfo")
	public ResponseEntity<String> insertstudinfo(@RequestBody String studinfo) throws JsonProcessingException
	{
		
		Studentinfo stud=new ObjectMapper().readValue(studinfo, Studentinfo.class);
	     sr.insert(stud);
	     
	     return new ResponseEntity<>("Record inserted Successfully",HttpStatus.OK);
		
	}
	@GetMapping("/hello")
	public String hello()
	{
		return "Hello";
	}
	@GetMapping("/hellourl")
	public String getvalues()
	{
		RestTemplate rs=new RestTemplate();
		String url="http://localhost:8090/student/hello";

	String ad=rs.getForObject(url, String.class);
		return ad;
		
	}
	@GetMapping("/getadmin")
	//We can get the values only in list.. Because we have used crudrepository
	public List<Studentadmin> getstudentval()
	{
		//Creating a resttemplate to call another restservice..
		RestTemplate rs=new RestTemplate();
		//url which is to be called..
		String url="http://localhost:8090/student/Admin";
		//Getting the array of objects.. Studentadmin[]
		Studentadmin[] stud=rs.getForObject(url,Studentadmin[].class);
		//Returning as an array..
		
		return Arrays.asList(stud);
	}
	/*public String getResponseStr(String resp) {
        return "Webservice_Response" + resp;
    }*/
	


}
