package studentinfo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

//Crud repository is used to work with the database.. Create,Read,Update and delete operations..
//No need to create our own methods..
//it is a marker interface.it extends spring data repository..
//If we want to use crudrepository we need to create one interface and extend crud repository with the entity name and datatype..
import org.springframework.data.repository.CrudRepository;

public interface StudentadminRep extends CrudRepository<Studentadmin,String> {

	@Query(value ="SELECT * FROM admin WHERE name = ?1",nativeQuery = true)
	public Studentadmin findbyCollateId(String name);
}
