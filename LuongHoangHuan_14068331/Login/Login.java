package Login;
 
public class Login {
 
    public static boolean authenticate(String username, String password) {
        if (username.equals("Huan") || username.equals("Binh") && password.equals("quanlythuvien")) {
            return true;
        }
        return false;
    }
}