package com.example.Homework25.Service;

import com.example.Homework25.Employee;
import com.example.Homework25.Exception.EmployeeAlreadyAddedException;
import com.example.Homework25.Exception.EmployeeNotFoundException;
import com.example.Homework25.Exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    Employee[] Employees = {
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
    };
    private int size = 10;

    public void addEmployee(String surname, String name) {
        if (size >= Employees.length) {
            throw new EmployeeStorageIsFullException("Список сотрудников заполнен. Добавление нового сотрудника невозможно.");
        } else {
            for (int i = 0; i < Employees.length; i++) {
                if (Employees[i] == null) {
                    continue;
                }
                if (surname.equals(Employees[i].getSurname()) && name.equals(Employees[i].getName())) {
                    throw new EmployeeAlreadyAddedException("Сотрудник уже есть в базе данных. Добавление невозможно.");
                }
            }
            for (int i = 0; i < Employees.length; i++) {
                if (Employees[i] == null) {
                    Employee newEmployee = new Employee(surname, name);
                    Employees[i] = newEmployee;
                    size++;
                }
            }
        }
    }


    public void deleteEmployeeFio(String surname, String name) {
        for (int i = 0; i < Employees.length; i++) {
            if (Employees[i] == null) {
                continue;
            }
            if (surname.equals(Employees[i].getSurname()) && name.equals(Employees[i].getName())) {
                Employees[i] = null;
                size--;
                break;
            } else {
                throw new EmployeeNotFoundException("Поиск завершен. Данного сотрудника нет в базе данных.");
            }
        }
    }

    public void findEmployee(String surname, String name) {
        for (int i = 0; i < Employees.length; i++) {
            if (Employees[i] == null) {
                continue;
            }
            if (surname.equals(Employees[i].getSurname()) && name.equals(Employees[i].getName())) {
                System.out.println("Поиск выполнен");
            } else {
                throw new EmployeeNotFoundException("Поиск завершен. Данного сотрудника нет в базе данных.");
            }


        }
    }
}
