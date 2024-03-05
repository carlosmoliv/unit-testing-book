package chapter5.mockExamples;

import chapter5.Controller;
import chapter5.Database;
import chapter5.Report;
import interfaces.EmailGateway;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MockExample {
    // Using the Mock class from a mocking library to create a mock
    @Test
    public void sending_a_greetings_email() {
        EmailGateway mock = mock(EmailGateway.class);
        Controller sut = new Controller(mock);

        sut.greetUser("user@email.com");

        verify(mock, times(1)).sendGreetingsEmail("user@email.com");
    }

    // Using the Mock class to create a stub
    @Test
    public void creatingReport() {
        Database stub = mock(Database.class);
        when(stub.getNumberOfUsers()).thenReturn(10);
        Controller sut = new Controller(mock(EmailGateway.class));

        Report report = sut.createReport(stub);

        assertEquals(10, report.getNumberOfUsers());
    }
}
