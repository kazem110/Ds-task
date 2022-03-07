package repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entity.Department;

@Repository
public interface TestRepo extends CrudRepository<Department, Long> {


	 List<Department> findByName (String name);

}
