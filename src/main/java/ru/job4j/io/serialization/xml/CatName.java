package ru.job4j.io.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "")
public class CatName {

    @XmlAttribute
    private String name;

    public CatName() {

    }

    public CatName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CatName{"
                + "name='"
                + name + '\''
                + '}';
    }
}
