package io.github.lengors.micronaut.serde.examples;

import io.github.lengors.micronaut.serde.examples.domain.model.PojoWithPropertiesAndDefaultConstructorWithJsonCreator;
import io.github.lengors.micronaut.serde.examples.domain.model.PojoWithPropertiesAndDefaultConstructorWithoutJsonCreator;
import io.github.lengors.micronaut.serde.examples.domain.model.PojoWithPropertiesOnlyConstructor;
import io.micronaut.runtime.Micronaut;
import io.micronaut.serde.annotation.SerdeImport;

/**
 * Simple application for testing pojo serialization and deserialization.
 * Usage of {@link SerdeImport} would yield the same result as annotating
 * the pojos themselves with {@link io.micronaut.serde.annotation.Serdeable}.
 * This is only an example of how one could still use serde for serialization
 * and deserialization even if the pojos were coming from an external project.
 */
@SerdeImport.Repeated({
        @SerdeImport(PojoWithPropertiesAndDefaultConstructorWithoutJsonCreator.class),
        @SerdeImport(PojoWithPropertiesAndDefaultConstructorWithJsonCreator.class),
        @SerdeImport(PojoWithPropertiesOnlyConstructor.class)
})
public class Application {
    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}