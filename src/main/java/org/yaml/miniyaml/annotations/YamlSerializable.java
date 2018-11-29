package org.yaml.miniyaml.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface YamlSerializable {
    AccessType value() default AccessType.AUTO;
    String[] fields() default {};

    public enum AccessType {
        AUTO,
        PRIVATE,
        PROTECTED,
        PUBLIC
    }
}
