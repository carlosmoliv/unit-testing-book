package chapter2.trivialTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Trivial test covering a simple piece of code
// They are resistant to refactorings, and provide fast feedback but do not protect against regressions
public class UserTest {
    @Test
    public void test() {
        User sut = new User();

        sut.setName("John Smith");

        assertEquals("John Smith", sut.getName());
    }
}
