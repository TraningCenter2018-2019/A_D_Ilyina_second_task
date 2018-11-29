package org.yaml.miniyaml;

import java.io.Reader;
import java.io.Writer;

import java.util.List;

import org.yaml.miniyaml.reader.YamlReader;

public class YamlFactory {
    private YamlConfig yamlConfig;
    private YamlReader yamlReader;

    public YamlFactory() {
        this(new YamlConfig(), new YamlReader());
    }

    public YamlFactory(YamlConfig yamlConfig) {
        this(yamlConfig, new YamlReader());
    }

    public YamlFactory(YamlConfig yamlConfig, YamlReader yamlReader) {
        this.yamlConfig = yamlConfig;
        this.yamlReader = yamlReader;
    }

    public <T> List<T> load(Reader reader) {
        return null;
    }

    public <T> T load(Reader reader, Class c) {
        return null;
    }

    public void dump(Object data, Writer writer) {

    }
}
