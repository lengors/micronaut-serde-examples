package io.github.lengors.micronaut.serde.examples;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

@MicronautTest
class MicronautSerdeExamplesTest {
    private final EmbeddedApplication<?> application;

    MicronautSerdeExamplesTest(final EmbeddedApplication<?> application) {
        this.application = application;
    }

    @Test
    void testIfItWorks() {
        Assertions.assertTrue(application.isRunning());
    }
}
