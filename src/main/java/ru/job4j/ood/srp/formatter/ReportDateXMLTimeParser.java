package ru.job4j.ood.srp.formatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReportDateXMLTimeParser extends XmlAdapter<String, Calendar> {

    DateFormat format =  new SimpleDateFormat("dd:MM:yyyy HH:mm");

    @Override
    public Calendar unmarshal(String s) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(format.parse(s));
        return calendar;
    }

    @Override
    public String marshal(Calendar calendar) throws Exception {
        return format.format(calendar.getTime());
    }
}
