package messageRenderer;

public class FooterRenderer implements IRenderer {

    @Override
    public String render(Message message) {
        return "<i>" + message.getFooter() + "</i>";
    }
}
