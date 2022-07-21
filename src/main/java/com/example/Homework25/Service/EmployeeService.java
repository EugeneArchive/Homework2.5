package com.example.Homework25.Service;

import com.example.Homework25.Employee;
import com.example.Homework25.Exception.EmployeeAlreadyAddedException;
import com.example.Homework25.Exception.EmployeeNotFoundException;
import com.example.Homework25.Exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> Employees = new ArrayList<>(List.of(
            new Employee("Serebrov", "Eugene"),
            new Employee("Smirnov", "Denis"),
            new Employee("Baranov", "Maxim"),
            new Employee("Simonov", "Artem"),
            new Employee("Koshina", "Irina"),
            new Employee("Timofeeva", "Olga"),
            new Employee("Pastushenko", "Denis"),
            new Employee("Vorobev", "Roman"),
            new Employee("Karpunova", "Anna"),
            new Employee("Serebrova", "Natalia")
    ));
    private int size = 10;

    public void addEmployee(String surname, String name) {
        if (size >= Employees.size()) {
            throw new EmployeeStorageIsFullException("Список сотрудников заполнен. Добавление нового сотрудника невозможно.");
        } else {
            for (int i = 0; i < Employees.size(); i++) {
                if (Employees.get(i) == null) {
                    continue;
                }
                if (surname.equals(Employees.get(i).getSurname()) && name.equals(Employees.get(i).getName())) {
                    throw new EmployeeAlreadyAddedException("Сотрудник уже есть в базе данных. Добавление невозможно.");
                }
            }
            for (int i = 0; i < Employees.size(); i++) {
                if (Employees.get(i) == null) {
                    Employee newEmployee = new Employee(surname, name);
                    Employees.set(i, newEmployee);
                    size++;
                }
            }
        };
    }


    public void deleteEmployeeFio(String surname, String name) {
        for (int i = 0; i < Employees.size(); i++) {
            if (Employees.get(i) == null) {
                continue;
            }
            if (surname.equals(Employees.get(i).getSurname()) && name.equals(Employees.get(i).getName())) {
                Employees.set(i, null);
                size--;
                break;
            } else {
                throw new EmployeeNotFoundException("Поиск завершен. Данного сотрудника нет в базе данных.");
            }
        }
    }

    public void findEmployee(String surname, String name) {
        for (int i = 0; i < Employees.size(); i++) {
            if (Employees.get(i) == null) {
                continue;
            }
            if (surname.equals(Employees.get(i).getSurname()) && name.equals(Employees.get(i).getName())) {
                break;
            } else {
                throw new EmployeeNotFoundException("Поиск завершен. Данного сотрудника нет в базе данных.");
            }

        }
    }

    public List<Employee> printEmployee() {
       return Employees;
    }
}
