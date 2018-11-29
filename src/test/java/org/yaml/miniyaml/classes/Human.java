package org.yaml.miniyaml.classes;

import org.yaml.miniyaml.annotations.YamlField;
import org.yaml.miniyaml.annotations.YamlRootName;
import org.yaml.miniyaml.annotations.YamlSerializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@YamlSerializable(YamlSerializable.AccessType.PRIVATE)
@YamlRootName("person")
public class Human extends Mammal {
    protected List<Domestic> pets = new ArrayList<>();

    public Human(@YamlField("birthday") Date birthDate, int weight, String name) {
        super(birthDate, weight, name);
    }

    @Override
    public void makeSound() {
        System.out.println("Hello!");
    }

    public void addPet(Domestic pet) {
        pets.add(pet);
    }
}
