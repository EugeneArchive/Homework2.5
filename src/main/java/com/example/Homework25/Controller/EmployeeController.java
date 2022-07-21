package com.example.Homework25.Controller;

import com.example.Homework25.Employee;
import com.example.Homework25.Service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("surname") String surname, @RequestParam("name") String name) {
        employeeService.addEmployee(surname, name);
        return name + " " + surname + " добавлен";
    }
    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam("surname") String surname, @RequestParam("name") String name) {
        employeeService.deleteEmployeeFio(surname, name);
        return name + " " + surname + " удален.";
    }
}
