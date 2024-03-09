package chapter5.cqsPrinciple;

import chapter5.Controller;
import chapter5.Database;
import chapter5.Report;
import interfaces.EmailGateway;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

public class CqsPrincipleExample {
    @Test
    public void sending_a_greetings_email() {
        EmailGateway mock = mock(EmailGateway.class);
        Controller sut = new Controller(mock);

        sut.greetUser("user@email.com");

        // Substitutes a command, so it's a Mock
        verify(mock, times(1)).sendGreetingsEmail("user@email.com");
    }

    @Test
    public void creatingReport() {
        Database stub = mock(Database.class);

        // Substitutes a query, so it's a Stub
        when(stub.getNumberOfUsers()).thenReturn(10);
        Controller sut = new Controller(mock(EmailGateway.class));

        Report report = sut.createReport(stub);

        assertEquals(10, report.getNumberOfUsers());
    }
}
