package chapter5;

import interfaces.EmailGateway;

public class Controller {
    private final EmailGateway emailGateway;

    public Controller(EmailGateway emailGateway) {
        this.emailGateway = emailGateway;
    }

    public void greetUser(String emailAddress) {
        emailGateway.sendGreetingsEmail(emailAddress);
    }

    public Report createReport(Database database) {
        int numbersOfUsers = database.getNumberOfUsers();
        return new Report(numbersOfUsers);
    }
}