package com.crudsOperations.service;

import com.crudsOperations.model.Employee;
import com.crudsOperations.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> employeeList(){
        return  employeeRepo.findAll();
    }

    public  Employee addemployee(Employee employee){

        return  employeeRepo.save(employee);
    }

    public Optional<Employee> getEmployee(int id){
        return  employeeRepo.findById(id);
    }

    public Employee updateEmployee(Employee employee)
    {
        return employeeRepo.save(employee);
    }
    public void deleteEmployee(int id){
         employeeRepo.deleteById(id);
    }
}
