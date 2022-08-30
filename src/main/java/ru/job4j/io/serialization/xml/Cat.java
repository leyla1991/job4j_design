package ru.job4j.io.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "cat")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cat {

    @XmlAttribute
    private boolean sex;

    @XmlAttribute
    private int age;
    private String talk;

    @XmlElementWrapper(name = "colors")
    @XmlElement(name = "color")
    private String[] color;
    private CatName catName;

    public Cat() {

    }

    public Cat(boolean sex, int age, String talk, String[] color, CatName catName) {
        this.sex = sex;
        this.age = age;
        this.talk = talk;
        this.color = color;
        this.catName = catName;
    }

    @Override
    public String toString() {
        return "Cat{"
                + "sex=" + sex
                + ", age=" + age
                + ", name='" + talk + '\''
                + ", color=" + Arrays.toString(color)
                + '}';
    }

    public static void main(String[] args) throws JAXBException {

        final Cat cat = new Cat(true, 2, "Мяу", new String[] {"Black", "White"}, new CatName("Кася"));

        JAXBContext context = JAXBContext.newInstance(Cat.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(cat, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
