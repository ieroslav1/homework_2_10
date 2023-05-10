package pro.sky.homework_2_10.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework_2_10.model.Employee;
import pro.sky.homework_2_10.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalaryFromDepartment(
            @RequestParam("departmentId") int department) {
        return departmentService.getEmployeeWithMaxSalaryFromDepartment(department);
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalaryFromDepartment(
            @RequestParam("departmentId") int department) {
        return departmentService.getEmployeeWithMinSalaryFromDepartment(department);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> getEmployeesFromDepartment(@RequestParam("departmentId") int department) {
        return departmentService.getAllEmployeesFromDepartment(department);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getEmployees() {
        return departmentService.getEmployeesByDepartment();
    }

}