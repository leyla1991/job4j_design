package ru.job4j.ood.srp.report;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;





import java.util.Calendar;
import java.util.function.Predicate;

public class ReportJSON implements Report {

    private Store store;

    private DateTimeParser<Calendar> date;
public ReportJSON(Store store, DateTimeParser<Calendar> date) {
        this.store = store;
        this.date = date;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        JSONArray js = new JSONArray();
        for (Employee employee : store.findBy(filter)) {
            JSONObject json = new JSONObject();
            json.put("name", employee.getName());
            json.put("hired", date.parse(employee.getHired()));
            json.put("fired", date.parse(employee.getFired()));
            json.put("salary", employee.getSalary());
            js.put(json);
        }

        return js.toString(4);
    }
}
