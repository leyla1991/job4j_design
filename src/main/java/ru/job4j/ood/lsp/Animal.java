package ru.job4j.ood.lsp;

public class Animal {


    private boolean animals;
    private int active;
    public AnimalType animalType;


    public Animal(boolean animals, int active, AnimalType animalType) {
        validate(animals);
        this.animals = animals;
        this.active = active;
        this.animalType = animalType;
    }

    public void validate(boolean animals) {
        if (!animals) {
            throw new IllegalArgumentException("Not animal!!!");
        }
    }
    public void run() {
        if (active < 0) {
            throw new IllegalArgumentException("Animal need sleep");
        }
    }

    /*
    * Перечисление типов с помощью enum может вызвать нарушение LSP,
    * так как есть вероятность добавления разных свойств или доп.типов, что приведет к изменению кода.
     */
    public String eat(Animal animal) {
        String rsl = "";
        if (animal.animalType == AnimalType.PREDATOR) {
            rsl = "The Animal eats meat";
        } else if (animal.animalType == AnimalType.HERBIVORE) {
            rsl = "The Animal eats herb";
        } else if (animal.animalType == AnimalType.BLOODSUCKER) {
            rsl = "The Animal drink blood";
        } else {
            rsl = "The Animal dead";
        }
        return rsl;
    }

    public void setAnimals(Animal animal) {
        validate(animal.animals);
        this.animalType = animalType;
    }

    public void sleep() {
    }
}

class Cat extends Animal {


    public Cat(boolean animals, int active, AnimalType animalType) {
        super(animals, active, animalType);
    }


    /*
     В методе run было усилено Предусловие из базового класса Animal.
     Это является нарушением контракта LSP
     */
    public void run(int active) {
        if (active < 10) {
            throw new IllegalArgumentException("Cat need sleep");
        }
        super.sleep();
    }

 /*
 Метод setAnimals нарушает контракт LSP. Не соблюдено условие предка, не проводится проверка на валидацию
  */
    @Override
    public void setAnimals(Animal anima) {
        this.animalType = animalType;
    }
}
