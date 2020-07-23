package Java_Assignment.Java_Assignment.Service;
import Java_Assignment.Java_Assignment.JavaAssignmentApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Java_Assignment.Java_Assignment.doa.EmployeeRepository;
import Java_Assignment.Java_Assignment.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.*;
import java.util.Optional;

@Service
public class EmployeeService {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(JavaAssignmentApplication.class);
    @Autowired
    EmployeeRepository employeeRepository;


    public void add(Employee employee) {
        logger.info("New Employee Added!");
        employeeRepository.save(employee);
    }


    public List<Employee> getIdInformation(Long id) {
        List<Employee> list = new ArrayList<>();
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employeeRepository.findById(id).isPresent())
        {
            logger.info("Employee found for given id!");
            list.add(employee.get());
        }
        else{
            for (Employee e : employeeRepository.findAll())
            {
                logger.error("Didnt find employee of the id given!");
                logger.info("Showing all the employees");
                list.add(e);
            }
        }
        return list;
    }

    public ArrayList<Employee> getDesignationInformation(String designation) {
       ArrayList<Employee> employee =  employeeRepository.findAllByDesignation(designation);
       if(!(employee.isEmpty())){
            logger.info("Found employee for the given designation!");
           return employeeRepository.findAllByDesignation(designation);
       }
       else{
           logger.error("Did not find any employees of the given designation");
           return null;
       }
    }

    public ArrayList<Employee> showEmployee() {
        logger.info("Displaying list of employees!");
        return (ArrayList<Employee>) employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee1 , Long id){
        return  employeeRepository.findById(id)
            .map(employee -> {
                logger.info("Updated employee!");
                employee.setName(employee1.getName());
        employee.setDate_of_joining(employee1.getDate_of_joining());
        employee.setDesignation(employee1.getDesignation());
        employee.setEmail(employee1.getEmail());
        employee.setPhone(employee1.getPhone());
        employee.setReporting_manager(employee1.getReporting_manager());
        employee.setTeam(employee1.getTeam());
        employee.setUpdate_date(new Date());
        return employeeRepository.save(employee);
         })
            .orElseGet(() -> {
                logger.error("Did not find employee of the given id.");
                logger.info("Added a new employee!");
                employee1.setId(id);
        return employeeRepository.save(employee1);
    });
    }

    public boolean deleteEmployee(Long id){
        Optional<Employee> employee = employeeRepository.findById(id);
            if(employee.isPresent()){
                logger.info("Employee deleted!");
                employeeRepository.deleteById(id);
            return true;
        }
            else
            {
                logger.error("Did not find the employee.");
            }
        return false;
    }
}
