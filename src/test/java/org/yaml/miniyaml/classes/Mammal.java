package org.yaml.miniyaml.classes;

import java.util.*;

public abstract class Mammal {
    private Date birthDate;
    private int weight;
    private String name = "";

    public Mammal(Date birthDate, int weight) {
        this.birthDate = birthDate;
        this.weight = weight;
    }

    public Mammal(Date birthDate, int weight, String name) {
        this.birthDate = birthDate;
        this.weight = weight;
        this.name = name;
    }

    public abstract void makeSound();

    public Date getBirthDate() {
        return birthDate;
    }

    public int getWeight() {
        return weight;
    }
}

abstract class Domestic extends Mammal {
    private Human master;

    public Domestic(Date birthDate, int weight, String name, Human master) {
        super(birthDate, weight, name);
        this.master = master;
    }
}

abstract class Wild extends Mammal {
    private String location;

    public Wild(Date birthDate, int weight, String name, String location) {
        super(birthDate, weight, name);
        this.location = location;
    }
}
