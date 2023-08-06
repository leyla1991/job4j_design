package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class ReportBuhTest {

    @Test
    public void generate() {
        MemStore memStore = new MemStore();
        Calendar now = Calendar.getInstance();
        InMemoryCurrencyConverter converter = new InMemoryCurrencyConverter();
        Employee worker = new Employee("Ivan", now, now, 100);
        memStore.add(worker);
        DateTimeParser<Calendar> date = new ReportDateTimeParser();
        ReportBuh report = new ReportBuh(memStore, date, converter, Currency.EUR, Currency.RUB);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Converter;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(date.parse(worker.getHired())).append(" ")
                .append(date.parse(worker.getFired())).append(" ")
                .append(converter.convert(Currency.EUR, worker.getSalary(), Currency.RUB))
                .append(System.lineSeparator());
        assertThat(report.generate(em -> true)).isEqualTo(expect.toString());
    }

}