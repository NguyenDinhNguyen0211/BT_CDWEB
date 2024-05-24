package btgk.ltw.springboot.Utils;

import btgk.ltw.springboot.model.User;
import jakarta.servlet.http.HttpSession;

public class AuthUtils {
    public static final String USER_SESSION = "USER";
    public static boolean isAuth(HttpSession session) {
        User auth = (User) session.getAttribute(USER_SESSION);
        if (auth == null) {
            return false;
        }
        return true;
    }
    public static User getAuth(HttpSession session) {
        return (User) session.getAttribute(USER_SESSION);
    }
}
