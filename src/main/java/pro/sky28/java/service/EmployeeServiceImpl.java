package pro.sky28.java.service;

import org.springframework.stereotype.Service;
import pro.sky28.java.Employee;
import pro.sky28.java.exception.EmployeeAlreadyAddedException;
import pro.sky28.java.exception.EmployeeNotFoundException;
import pro.sky28.java.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Диана", "Титова", 230000, "1"),
            new Employee("Михаил", "Иванов", 250000, "2"),
            new Employee("Лилия", "Нечаева", 215000, "3"),
            new Employee("Денис", "Грачев", 145000, "4"),
            new Employee("Матвей", "Григорьев", 185000, "5"),
            new Employee("Владислав", "Пугачев", 198000, "1"),
            new Employee("Андрей", "Тихонов", 220000, "2"),
            new Employee("Ольга", "Дубровина", 300000, "3"),
            new Employee("Владимир", "Королев", 280000, "4"),
            new Employee("Варвара", "Андреева", 260000, "5")
    ));

    private static final int LIMIT = 20;

    public Employee add(String firstName, String lastName, int salary, String department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee remove(String firstName, String lastName, int salary, String department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    public Employee find(String firstName, String lastName, int salary, String department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public List<Employee> getAll() {
        return new ArrayList<>((employees));
    }
}
