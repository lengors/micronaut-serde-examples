package io.github.lengors.micronaut.serde.examples.domain.model;

import io.micronaut.serde.ObjectMapper;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@MicronautTest
class PojoTests {
    private static final String name = "testName";
    private static final String value = "testValue";
    private static final String pojoString = String.format("{\"name\":\"%s\",\"value\":\"%s\"}", name, value);

    private final ObjectMapper objectMapper;

    PojoTests(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Shows that if pojo contains a default constructor (even if other is available)
     * and no setters, serde won't be able to deserialize the value.
     *
     * @throws IOException if deserialization fails
     */
    @Test
    void testIfObjectMapperProperlyDeserializesPojoWithPropertiesAndDefaultConstructorWithoutJsonCreator() throws IOException {
        final var pojoObject = objectMapper.readValue(pojoString, PojoWithPropertiesAndDefaultConstructorWithoutJsonCreator.class);
        Assertions.assertNull(pojoObject.getName());
        Assertions.assertNull(pojoObject.getValue());
    }

    /**
     * Shows that if pojo contains a default constructor (even if other is available)
     * and no setters, serde is only capable of deserializing it correctly if the
     * properties constructors is annotated with {@link com.fasterxml.jackson.annotation.JsonCreator}.
     *
     * @throws IOException if deserialization fails
     */
    @Test
    void testIfObjectMapperProperlyDeserializesPojoWithPropertiesAndDefaultConstructorWithJsonCreator() throws IOException {
        final var pojoObject = objectMapper.readValue(pojoString, PojoWithPropertiesAndDefaultConstructorWithJsonCreator.class);
        Assertions.assertEquals(name, pojoObject.getName());
        Assertions.assertEquals(value, pojoObject.getValue());
    }

    /**
     * Shows that if pojo contains only a properties constructor (with no default constructor)
     * and no setters, serde is still capable of deserializing it correctly.
     *
     * @throws IOException if deserialization fails
     */
    @Test
    void testIfObjectMapperProperlyDeserializesPojoWithPropertiesOnlyCorrectly() throws IOException {
        final var pojoObject = objectMapper.readValue(pojoString, PojoWithPropertiesOnlyConstructor.class);
        Assertions.assertEquals(name, pojoObject.getName());
        Assertions.assertEquals(value, pojoObject.getValue());
    }

    /**
     * Shows that if pojo contains a default constructor (even if other is available)
     * and no setters, serde is capable of serializing the value.
     *
     * @throws IOException if serialization fails
     */
    @Test
    void testIfObjectMapperProperlySerializesPojoWithPropertiesAndDefaultConstructorWithoutJsonCreator() throws IOException {
        final var pojoObject = new PojoWithPropertiesAndDefaultConstructorWithoutJsonCreator(name, value);
        final String actualPojoString = objectMapper.writeValueAsString(pojoObject);
        Assertions.assertEquals(pojoString, actualPojoString);
    }

    /**
     * Shows that if pojo contains a default constructor (even if other is available)
     * and no setters, serde is still capable of serializing it correctly even if the
     * properties constructors is annotated with {@link com.fasterxml.jackson.annotation.JsonCreator}.
     *
     * @throws IOException if serialization fails
     */
    @Test
    void testIfObjectMapperProperlySerializesPojoWithPropertiesAndDefaultConstructorWithJsonCreator() throws IOException {
        final var pojoObject = new PojoWithPropertiesAndDefaultConstructorWithJsonCreator(name, value);
        final String actualPojoString = objectMapper.writeValueAsString(pojoObject);
        Assertions.assertEquals(pojoString, actualPojoString);
    }

    /**
     * Shows that if pojo contains only a properties constructor (with no default constructor)
     * and no setters, serde is still capable of serializing it correctly.
     *
     * @throws IOException if serialization fails
     */
    @Test
    void testIfObjectMapperProperlySerializesPojoWithPropertiesOnlyCorrectly() throws IOException {
        final var pojoObject = new PojoWithPropertiesOnlyConstructor(name, value);
        final String actualPojoString = objectMapper.writeValueAsString(pojoObject);
        Assertions.assertEquals(pojoString, actualPojoString);
    }
}
