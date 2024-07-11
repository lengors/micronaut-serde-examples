package io.github.lengors.micronaut.serde.examples.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Pojo used for showing the capabilities of serde for serialization and
 * deserialization, for pojos containing no default and no setters.
 * Could be replaced with a record.
 */
public class PojoWithPropertiesOnlyConstructor {
    @JsonProperty("name")
    private final String name;

    @JsonProperty("value")
    private final String value;

    public PojoWithPropertiesOnlyConstructor(
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
