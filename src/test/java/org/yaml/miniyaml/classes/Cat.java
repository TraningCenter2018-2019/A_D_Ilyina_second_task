package org.yaml.miniyaml.classes;

import org.yaml.miniyaml.annotations.YamlIgnore;
import org.yaml.miniyaml.annotations.YamlSerializable;

import java.util.Date;

@YamlSerializable
public class Cat extends Domestic {
    public Cat(Date birthDate, int weight, String name, @YamlIgnore Human master) {
        super(birthDate, weight, name, master);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}
