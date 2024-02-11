package chapter2.falsePositive;

import java.util.List;

public class MessageRenderer implements IRenderer {
    private List<IRenderer> subRenderers;

    public MessageRenderer() {
        subRenderers = List.of(
                new HeaderRenderer(),
                new BodyRenderer(),
                new FooterRenderer()
        );
    }

    public List<IRenderer> getSubRenderers() {
        return subRenderers;
    }

    @Override
    public String render(Message message) {
        return subRenderers.stream()
                .map(renderer -> renderer.render(message))
                .reduce("", (str1, str2) -> str1 + str2);
    }
}
