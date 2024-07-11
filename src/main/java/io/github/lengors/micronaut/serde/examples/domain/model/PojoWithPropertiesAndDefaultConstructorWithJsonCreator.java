package io.github.lengors.micronaut.serde.examples.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Pojo used for showing the capabilities of serde for serialization and
 * deserialization, for pojos containing multiple constructor, of which,
 * one is the default constructor, another is annotated with
 * {@link com.fasterxml.jackson.annotation.JsonCreator}, and no setters.
 */
public class PojoWithPropertiesAndDefaultConstructorWithJsonCreator {
    @JsonProperty("name")
    private String name;

    @JsonProperty("value")
    private String value;

    public PojoWithPropertiesAndDefaultConstructorWithJsonCreator() {

    }

    @JsonCreator
    public PojoWithPropertiesAndDefaultConstructorWithJsonCreator(
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
