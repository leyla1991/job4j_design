package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

class ReportCSVTest {

    @Test
    void generate() {
        MemStore store = new MemStore();
        DateTimeParser<Calendar> date = new ReportDateTimeParser();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 123);
        store.add(worker);
        Report report = new ReportCSV(store, date);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(date.parse(worker.getHired())).append(";")
                .append(date.parse(worker.getFired())).append(";")
                .append(worker.getSalary())
                .append(System.lineSeparator());
        assertThat(report.generate(em -> true)).isEqualTo(expect.toString());
    }
}