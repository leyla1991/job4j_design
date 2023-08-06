package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportBuh implements Report {

    private Store store;
    private DateTimeParser<Calendar> dateTimeParser;
    private InMemoryCurrencyConverter converter;
    private Currency target;
    private Currency source;


    public ReportBuh(Store store, DateTimeParser<Calendar> dateTimeParser, InMemoryCurrencyConverter converter, Currency source, Currency target) {
        this.dateTimeParser = dateTimeParser;
        this.store = store;
        this.converter = converter;
        this.target = target;
        this.source = source;
    }


    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Converter;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(" ")
                    .append(dateTimeParser.parse(employee.getHired())).append(" ")
                    .append(dateTimeParser.parse(employee.getFired())).append(" ")
                    .append(converter.convert(source, employee.getSalary(), target))
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
