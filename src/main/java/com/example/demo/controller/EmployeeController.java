package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController annotation contains @Controller and @ResponseBody
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        super();
        this.employeeService = employeeService;
    }

    //@RequestBody -> allow us to retrieve the request's body and automatically convert it to java object.
    //build create employee for REST API.
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
      return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    //build get all employee for REST API.
    @GetMapping()
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployess();
    }

    //build get employee by id for REST API.
    //http://localhost:8080/api/employees/1
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployees(@PathVariable("id") long employeeId ){
       return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }

    //build update employee REST API.
   //http://localhost:8080/api/employees/1
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee){
      return new ResponseEntity<Employee>(employeeService.updateEmployee( employee, id), HttpStatus.OK);
    }

    //build delete employee REST API.
    //http://localhost:8080/api/employees/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee (@PathVariable("id") long id ){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
    }
}
