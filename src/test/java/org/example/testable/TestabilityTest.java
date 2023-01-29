package org.example.testable;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;


class TestabilityTest {

    LoggerImpl logger = new LoggerImpl(); //use our own test double

    MailSender mailSender = Mockito.mock(MailSender.class); //use mockito to mock mailSender

    Testability testability = new Testability(logger, mailSender);

    @Test
    void runWithValidEmailShouldLogAndSendMail() {
        testability.run();

        assertTrue(logger.logIsCalled);
        Mockito.verify(mailSender).sendMail(anyString(),anyString());
    }

    @Test
    void runWithInvalidEmailShouldLogMessageWithErrorLevel() {
        doThrow(new IllegalArgumentException()).when(mailSender).sendMail(anyString(),anyString());

        testability.run();

        assertEquals(2,logger.count);

    }

}