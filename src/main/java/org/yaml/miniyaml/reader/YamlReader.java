package org.yaml.miniyaml.reader;

import org.yaml.miniyaml.parser.YamlParser;

public class YamlReader {
    private YamlParser parser;

    public YamlReader() {
        this(new YamlParser());
    }

    public YamlReader(YamlParser parser) {
        this.parser = parser;
    }
}
