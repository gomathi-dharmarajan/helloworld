package studentinfo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Studentinforep extends CrudRepository<Studentinfo,String> {
	//@Query(value="insert into studdet (admin) values(?)",nativeQuery=true)
	//public void saveall(String name);

	}
