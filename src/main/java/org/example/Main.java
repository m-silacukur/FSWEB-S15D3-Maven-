package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();

        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));
        employees.add(null);

        System.out.println("=== DUPLICATES ===");
        findDuplicates(employees).forEach(System.out::println);

        System.out.println("\n=== UNIQUES (Map) ===");
        findUniques(employees).forEach((k, v) -> System.out.println(k + " -> " + v));

        System.out.println("\n=== REMOVE DUPLICATES ===");
        removeDuplicates(employees).forEach(System.out::println);
    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        List<Employee> duplicates = new LinkedList<>();

        for (Employee emp : list) {
            if (emp == null) continue;
            countMap.put(emp.getId(), countMap.getOrDefault(emp.getId(), 0) + 1);
        }

        for (Employee emp : list) {
            if (emp == null) continue;
            if (countMap.get(emp.getId()) > 1 && !duplicates.contains(emp)) {
                duplicates.add(emp);
            }
        }

        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        HashMap<Integer, Employee> uniqueMap = new HashMap<>();

        for (Employee emp : list) {
            if (emp == null) continue;
            if (!uniqueMap.containsKey(emp.getId())) {
                uniqueMap.put(emp.getId(), emp);
            }
        }

        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        List<Employee> result = new LinkedList<>();

        for (Employee emp : list) {
            if (emp == null) continue;
            countMap.put(emp.getId(), countMap.getOrDefault(emp.getId(), 0) + 1);
        }

        for (Employee emp : list) {
            if (emp == null) continue;
            if (countMap.get(emp.getId()) == 1) {
                result.add(emp);
            }
        }

        return result;
    }
}