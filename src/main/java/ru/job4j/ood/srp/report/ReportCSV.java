package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportCSV implements Report {
    private Store store;
    private DateTimeParser<Calendar> date;

    public ReportCSV(Store store, DateTimeParser<Calendar> date) {
        this.date = date;
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String delimiter = ";";
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(delimiter)
                    .append(date.parse(employee.getHired())).append(delimiter)
                    .append(date.parse(employee.getFired())).append(delimiter)
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
