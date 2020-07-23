package Java_Assignment.Java_Assignment.doa;

import Java_Assignment.Java_Assignment.models.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {

    ArrayList<Employee> findAllByDesignation(String designation);
}
