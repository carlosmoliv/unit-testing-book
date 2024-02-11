package chapter2.falsePositive;

public class FooterRenderer implements IRenderer {

    @Override
    public String render(Message message) {
        return "<i>" + message.getFooter() + "</i>";
    }
}
