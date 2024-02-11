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
}
