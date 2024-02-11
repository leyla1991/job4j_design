package ru.job4j.ood.lsp.parking;

public class Cars {


    private String name;
    private int size;




    public Cars(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Cars{"
                + "name='" + name + '\''
                + '}';
    }
}