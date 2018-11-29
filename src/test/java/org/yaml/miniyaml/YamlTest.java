package org.yaml.miniyaml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.List;
import java.util.Calendar;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.time.Instant;
import java.time.Duration;

import org.yaml.miniyaml.classes.*;


public class YamlTest
{
    /**
    * Test SAX parser.
    */
    @Test
    public void testSAXParser() throws FileNotFoundException {
        FileReader reader = new FileReader("src/test/resources/test1.yaml");
        YamlConfig config = new YamlConfig();
        config.setSAXParser();
        YamlFactory yf = new YamlFactory(config);

        Object data = yf.load(reader, Dog.class);

        assertTrue(data instanceof Dog);

        Dog dog = (Dog)data;
        dog.makeSound();

        assertEquals(10, dog.getWeight());
    }

    /**
     * Test DOM parser.
     */
    @Test
    public void testDOMParser() throws FileNotFoundException {
        FileReader reader = new FileReader("src/test/resources/test1.yaml");
        YamlConfig config = new YamlConfig();
        config.setDOMParser();
        YamlFactory yf = new YamlFactory(config);

        Object data = yf.load(reader, Dog.class);

        assertTrue(data instanceof Dog);

        Dog dog = (Dog)data;
        dog.makeSound();

        assertEquals(10, dog.getWeight());
    }

    /**
     * Test serializer.
     */
    @Test
    public void testSerialization()  throws IOException {
        FileWriter writer = new FileWriter("src/test/resources/output1.yaml");
        YamlFactory yf = new YamlFactory();

        Calendar cal = Calendar.getInstance();
        cal.set(2000, 1, 5);
        Human pete = new Human(cal.getTime(), 70, "Pete");
        yf.dump(pete, writer);
    }

    /**
     * Test looped serialization-deserialization sequence.
     */
    @Test
    public void testManySerializations() throws IOException {
        FileReader reader = new FileReader("src/test/resources/test2.yaml");
        FileWriter writer = new FileWriter("src/test/resources/test2.yaml");
        YamlFactory yf = new YamlFactory();

        Instant start = Instant.now();
        for (int i = 1; i < 30; i++) {
            Dog dog = yf.load(reader, Dog.class);
            yf.dump(dog, writer);
        }
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Serialization sequence successful. Time elapsed: " + timeElapsed);
    }
}
