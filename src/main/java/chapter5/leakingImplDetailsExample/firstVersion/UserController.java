package chapter5.leakingImplDetailsExample.firstVersion;

// Client code
public class UserController {
    private User getUserFromDatabase(int userId) {
        return new User();
    }

    private void saveUserToDatabase(User user) {
        System.out.println("User saved");
    }

    public void renameUser(int userId, String newName) {
        User user = getUserFromDatabase(userId);

        // Implementation details leaking
        user.name = user.normalizeName(newName);

        saveUserToDatabase(user);
    }
}
