package io.github.lengors.micronaut.serde.examples.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Pojo used for showing the capabilities of serde for serialization and
 * deserialization, for pojos containing multiple constructor, of which,
 * one is the default constructor, and no setters.
 */
public class PojoWithPropertiesAndDefaultConstructorWithoutJsonCreator {
    @JsonProperty("name")
    private String name;

    @JsonProperty("value")
    private String value;

    public PojoWithPropertiesAndDefaultConstructorWithoutJsonCreator() {

    }

    public PojoWithPropertiesAndDefaultConstructorWithoutJsonCreator(
            final String name,
            final String value
    ) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
