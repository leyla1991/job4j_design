package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 5);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
    }

    @Test
    void isThisCube() {
        Box box = new Box(6, 4);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube");
    }

    @Test
    void isThisUnknown() {
        Box box = new Box(3, 4);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void isAreaCube() {
        Box box = new Box(6, 5);
        double result = box.getArea();
        assertThat(result).isEqualTo(150, withPrecision(0.006d));
    }

    @Test
    void isAreaTetrahedron() {
        Box box = new Box(4, 6);
        double result = box.getArea();
        assertThat(result).isEqualTo(62.35, withPrecision(0.006d));
    }

    @Test
    void isAreaSphere() {
        Box box = new Box(0, 3);
        double result = box.getArea();
        assertThat(result).isEqualTo(113.097, withPrecision(0.006d));
    }

    @Test
    void isAreaUnknown() {
        Box box = new Box(3, 3);
        double result = box.getArea();
        assertThat(result).isEqualTo(0);
    }
}