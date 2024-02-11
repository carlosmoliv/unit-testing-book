package chapter2.falsePositive;

public class BodyRenderer implements IRenderer {

    @Override
    public String render(Message message) {
        return "<b>" + message.getBody() + "</b>";
    }
}
