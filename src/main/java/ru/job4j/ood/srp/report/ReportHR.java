package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.List;
import java.util.Comparator;
import java.util.function.Predicate;

public class ReportHR implements Report {

    private final Store store;
    private Comparator<Employee> comparator;

    public ReportHR(Store store, Comparator<Employee> comparator) {
        this.store = store;
        this.comparator = comparator;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;").append(System.lineSeparator());
        List<Employee> employees = store.findBy(filter);
        employees.sort(comparator);
        for (Employee employee : employees) {
            text.append(employee.getName()).append(" ");
            text.append(employee.getSalary());
            text.append(System.lineSeparator());
        }
        return text.toString();
    }
}
