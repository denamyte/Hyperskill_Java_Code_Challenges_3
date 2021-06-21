class BoxInside {

    public static void showAnimal(Box box) {
        System.out.println(box.getAnimal());
    }
}

// Don't change the code below
class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class Box<T extends Animal> {

    private T animal;

    void setAnimal(T animal) {
        this.animal = animal;
    }

    T getAnimal() {
        return animal;
    }
}