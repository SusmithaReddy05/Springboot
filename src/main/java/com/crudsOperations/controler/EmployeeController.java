package com.crudsOperations.controler;

import com.crudsOperations.model.Employee;
import com.crudsOperations.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee>  getAllEmployees(){
        return employeeService.employeeList();
    }
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        return employeeService.addemployee(employee);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id)
    {
        Optional<Employee> employee=employeeService.getEmployee(id);
        return employee.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
@PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody Employee employee)
    {
        Optional<Employee> employeeOptional=employeeService.getEmployee(id);
        if(employeeOptional.isPresent()){
            Employee employee1=employeeOptional.get();
            employee1.setName(employee.getName());
            employee1.setRole(employee.getRole());
            employee1.setSal(employee.getSal());
            Employee updateEmployee=employeeService.updateEmployee(employee1);
            return ResponseEntity.ok(updateEmployee);
        }
        else {
            return  ResponseEntity.notFound().build();
        }
    }
@DeleteMapping("/employee/{id}")
    public  ResponseEntity<Void> deleteEmployee(@PathVariable int id)
    {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
