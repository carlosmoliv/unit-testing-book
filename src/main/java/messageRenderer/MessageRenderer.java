package messageRenderer;

import messageRenderer.*;

import java.util.List;

public class MessageRenderer implements IRenderer {
    // Leaking implementation details because the collection here is public and its not part of the observable behavior
    // public final List<IRenderer> subRenderers;

    private final List<IRenderer> subRenderers;

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
