package Java_Assignment.Java_Assignment.controller;


import Java_Assignment.Java_Assignment.JavaAssignmentApplication;
import Java_Assignment.Java_Assignment.Service.EmployeeService;
import Java_Assignment.Java_Assignment.doa.EmployeeRepository;
import Java_Assignment.Java_Assignment.models.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(JavaAssignmentApplication.class);

    @Autowired
    EmployeeService employeeService;

    public static Principal principal;

    @PostMapping( consumes="application/json")
    public boolean signUp(@RequestBody Employee employee)
    {
        employee.setCreate_date(new Date());
        employee.setUpdate_date(new Date());
        logger.info("Post Api called for new employee");
        logger.info(employee.toString());
        System.out.println(employee.toString());
        try{
            employeeService.add(employee);
            return true;
        }
        catch (Exception e){
            logger.error("exception occured");
            return false;
        }
    }

    @GetMapping(path="/" , produces = "application/json")
    public ArrayList<Employee> showEmployee()
    {
        logger.info("Get Api called to show list of employees");
        try{
            return employeeService.showEmployee();
        }
        catch(Exception e)
        {
            logger.error("exception occured");
            return null;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Employee> getId(@PathVariable Long id) {
        logger.info("Get Api called to get information about a particular id employee");
        try {
            return employeeService.getIdInformation(id);
        }
        catch (Exception e)
        {
            logger.error("exception occured");
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<Employee> getDesignation(@RequestParam(value="designation") String designation) {
        logger.info("Get Api called to get information about a particular designation employee");
        try {
            return employeeService.getDesignationInformation(designation);
        }
        catch (Exception e)
        {
            logger.error("exception occured");
            return null;
        }
    }

    @PutMapping("/{id}")
     public Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        logger.info("Put Api called to update information about a particular id employee");
        try{
            return employeeService.updateEmployee(newEmployee,id);
        }
        catch (Exception e)
        {
            logger.error("exception occured");
            return null;
        }
    }

    @DeleteMapping(path="/{id}")
    public  boolean deleteEmployee(@PathVariable Long id , @RequestBody Employee employee)
    {
        logger.info("Delete Api called to delete particular id employee");
        try{
        return  employeeService.deleteEmployee(id);
        }
        catch (Exception e)
        {
            logger.error("exception occured");
            return false;
        }
    }
}
