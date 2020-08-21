package ooad;

import lombok.AllArgsConstructor;
import lombok.Data;

// class bank
@Data
@AllArgsConstructor
class Bank {
    private String name;
}

// employee class
@Data
@AllArgsConstructor
class Employee {
    private String name;
}

// Association between both the classes via their objects in main method
public class Association {
    public static void main(String[] args) {
        final Bank bank = new Bank("Axis");
        final Employee emp = new Employee("Neha");

        System.out.println(emp.getName() + " is employee of " + bank.getName());
    }
} 