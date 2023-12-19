public class UserAuthentication {
    private static final String VALID_USERNAME = "123";
    private static final String VALID_PASSWORD = "123";

    public static boolean authenticateUser(String username, String password) {
        return VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password);
    }
}