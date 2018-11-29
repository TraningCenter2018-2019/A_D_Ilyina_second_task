package org.yaml.miniyaml.classes;

import org.yaml.miniyaml.annotations.YamlIgnore;
import org.yaml.miniyaml.annotations.YamlSerializable;

import java.util.Date;

@YamlSerializable(fields={"birthDate", "weight", "name"})
public class Dog extends Domestic {
    public Dog(Date birthDate, int weight, String name, Human master) {
        super(birthDate, weight, name, master);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}
