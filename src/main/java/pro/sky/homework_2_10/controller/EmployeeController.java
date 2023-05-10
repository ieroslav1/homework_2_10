package pro.sky.homework_2_10.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework_2_10.model.Employee;
import pro.sky.homework_2_10.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, String lastName, @RequestParam ("departmentId") int department, int salary) {
        return service.add(firstName, lastName, department, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, String lastName, @RequestParam ("departmentId") int department, int salary) {
        return service.remove(firstName, lastName, department, salary);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, String lastName, @RequestParam ("departmentId") int department, int salary) {
        return service.find(firstName, lastName, department, salary);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return service.findAll();
    }
}
