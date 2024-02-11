package chapter2.falsePositive;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageRendererTest {
    // This test is too coupled to the SUT's implementation and not to the outcome.
    // Any refactoring to introduce an alternative implementation will fail because of the coupling.
    @Test
    public void messageRenderer_uses_correct_sub_renderers() {
        MessageRenderer sut = new MessageRenderer();
        List<IRenderer> renderers = sut.getSubRenderers();

        assertEquals(3, renderers.size());
        assertInstanceOf(HeaderRenderer.class, renderers.get(0));
        assertInstanceOf(BodyRenderer.class, renderers.get(1));
        assertInstanceOf(FooterRenderer.class, renderers.get(2));
    }

    // Refactored version of the test above:
    // Treating the MessageRenderer as black box and only focus in the observable behavior
    // In this version, the test is more resistant to refactoring
    // As long as the output remains the same
    @Test
    public void rendering_a_message() {
        MessageRenderer sut = new MessageRenderer();
        Message message = new Message();
        message.setHeader("h");
        message.setBody("b");
        message.setFooter("f");

        String html = sut.render(message);

        assertEquals("<h1>h</h1><b>b</b><i>f</i>", html);
    }
}
