package org.example;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class AppIT {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final InputStream stdin = System.in;
    private final Locale locale = Locale.getDefault();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        Locale.setDefault(Locale.ENGLISH);
    }

    @AfterEach
    void cleanUp() {
        System.setOut(standardOut);
        System.setIn(stdin);
        Locale.setDefault(locale);
    }

    @Test
    void invalidOperator() {
        String data = "%\n1,0\n2,0\n";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        App.main(Arrays.array(""));

        assertThat(outputStreamCaptor.toString()).contains("Invalid operator!");
    }

    @Test
    void additionOperator() {
        String lineSeparator = System.lineSeparator();
        String data = """
                +
                1.0
                2.0
                """;

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        App.main(Arrays.array(""));

        var result = outputStreamCaptor.toString().split(lineSeparator);

        assertThat(result).contains("1.0 + 2.0 = 3.0");
    }
}
