package chapter2.brittleTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


// Brittle test because it will turn red everytime that a refactoring occurs
// Test is coupled to the SUT's implementation details
public class UserRepositoryTest {

    public class UserRepository {
        public User getById(int id) {
            // Implementation...
            return null; // Placeholder, implement the actual logic
        }

        public String lastExecutedSqlStatement;
    }

    // User class implementation...
    public class User {}
    @Test
    public void getById_executes_correct_SQL_code() {
        UserRepository sut = new UserRepository();
        User user = sut.getById(5);

        // assertEquals("SELECT * FROM dbo.[User] WHERE UserID = 5", sut.lastExecutedSqlStatement);
        assertEquals("SELECT * FROM User WHERE UserID = 5", sut.lastExecutedSqlStatement);
    }
}