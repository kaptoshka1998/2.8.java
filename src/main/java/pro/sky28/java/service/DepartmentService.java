package pro.sky28.java.service;

import org.springframework.stereotype.Service;
import pro.sky28.java.Employee;
import pro.sky28.java.exception.EmployeeNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final EmployeeServiceImpl employeeService;

    public DepartmentService(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    public Map<String, List<Employee>> allEmployees() {
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(e -> e.getEmployeeDepartment(), Collectors.toList()));
    }

    public List<Employee> AllEmployeesWithinSpecificDepartment(String department) {
        return employeeService.getAll().stream()
                .filter(e -> e.getEmployeeDepartment().equals(department))
                .toList();
    }

    public Employee maxSalaryWithinDepartment(String department) {
        return employeeService.getAll().stream()
                .filter(e -> e.getEmployeeDepartment().equals(department))
                .max(Comparator.comparingInt(e -> e.getEmployeeSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    public Employee minSalaryWithinDepartment(String department) {
        return employeeService.getAll().stream()
                .filter(e -> e.getEmployeeDepartment().equals(department))
                .min(Comparator.comparingInt(e -> e.getEmployeeSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }
}
