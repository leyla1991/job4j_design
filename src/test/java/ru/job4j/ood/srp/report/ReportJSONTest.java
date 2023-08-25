package ru.job4j.ood.srp.report;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class ReportJSONTest {

    @Test
    public void whenPut() {
        MemStore memStore = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        memStore.add(worker1);
        DateTimeParser<Calendar> date = new ReportDateTimeParser();
        Report report = new ReportJSON(memStore, date);
        String da = date.parse(now);
        String expected = String.format("""
                [{
                    "fired": "%s",
                    "name": "Ivan",
                    "hired": "%s",
                    "salary": 100
                }]""", da, da);
        assertThat(report.generate(em -> true)).isEqualTo(expected);
    }

    @Test
    public void whenThreeEmployeeThenReportGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 50_000);
        Employee worker2 = new Employee("Andrey", now, now, 60_000);
        Employee worker3 = new Employee("Petr", now, now, 65_000);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new ReportJSON(store, parser);
        String date = parser.parse(now);
        String expect = String.format("""
                [
                    {
                        "fired": "%s",
                        "name": "Ivan",
                        "hired": "%s",
                        "salary": 50000
                    },
                    {
                        "fired": "%s",
                        "name": "Andrey",
                        "hired": "%s",
                        "salary": 60000
                    },
                    {
                        "fired": "%s",
                        "name": "Petr",
                        "hired": "%s",
                        "salary": 65000
                    }
                ]""", date, date, date, date, date, date);
        assertThat(engine.generate(em -> true)).isEqualTo(expect);
    }


    @Test
    void generate() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Kolya", now, now, 200);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker1);
        store.add(worker2);
        Report jsonReport = new ReportJSON(store, parser);
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject1 = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        jsonObject1.put("name", worker1.getName());
        jsonObject1.put("hired", parser.parse(worker1.getHired()));
        jsonObject1.put("fired", parser.parse(worker1.getFired()));
        jsonObject1.put("salary", worker1.getSalary());
        jsonObject2.put("name", worker2.getName());
        jsonObject2.put("hired", parser.parse(worker2.getHired()));
        jsonObject2.put("fired", parser.parse(worker2.getFired()));
        jsonObject2.put("salary", worker2.getSalary());
        jsonArray.put(jsonObject1);
        jsonArray.put(jsonObject2);
        assertThat(jsonReport.generate(s -> true)).isEqualTo(jsonArray.toString(4));
    }

}