package chapter5;

import interfaces.EmailGateway;

public class EmailGatewayImpl implements EmailGateway {
    @Override
    public void sendGreetingsEmail(String emailAddress) {
        System.out.println("Sending greetings email to: " + emailAddress);
    }
}