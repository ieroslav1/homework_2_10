package pro.sky.homework_2_10.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.homework_2_10.exception.EmployeeAlreadyAddedException;
import pro.sky.homework_2_10.exception.EmployeeNotFoundException;
import pro.sky.homework_2_10.exception.EmployeeStorageIsFullException;
import pro.sky.homework_2_10.exception.EmployeeStringUtilsException;
import pro.sky.homework_2_10.model.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {

    private final Map<String, Employee> employees;
    private static final int MAX_EMPLOYEES = 4;

    public EmployeeService() {
        this.employees = new HashMap<>();
    }


    public Employee add(String firstName, String lastName, int department, int salary) {
        if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException();
        }
        checkString(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, department, salary);
        return employees.merge(employee.getFullName(), employee, (oldEmployee, newEmployee) -> {
            throw new EmployeeAlreadyAddedException();
        });
    }

    public Employee remove(String firstName, String lastName, int department, int salary) {
        checkString(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, department, salary);
        return employees.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(employee))
                .map(Map.Entry::getKey)
                .findFirst()
                .map(employees::remove)
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee find(String firstName, String lastName, int department, int salary) {
        checkString(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, department, salary);
        return employees.values()
                .stream()
                .filter(v -> v.equals(employee))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    public void checkString(String firstName, String lastName) {
        if (StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName)) {
            throw new EmployeeStringUtilsException();
        }
        if (!StringUtils.isAlpha(firstName) || !StringUtils.isAlpha(lastName)) {
            throw new EmployeeStringUtilsException();
        }
    }
}
