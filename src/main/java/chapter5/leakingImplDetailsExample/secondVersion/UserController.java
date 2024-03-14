package chapter5.leakingImplDetailsExample.secondVersion;

public class UserController {
    private User getUserFromDatabase(int userId) {
        return new User();
    }

    private void saveUserToDatabase(User user) {
        System.out.println("User saved");
    }

    public void renameUser(int userId, String newName) {
        User user = getUserFromDatabase(userId);
        // normalizeName now is hidden behind the private API. Not leaking anymore
        user.setName(newName);
        saveUserToDatabase(user);
    }
}
