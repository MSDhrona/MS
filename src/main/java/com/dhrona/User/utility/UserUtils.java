package com.dhrona.User.utility;

import org.mindrot.jbcrypt.BCrypt;

public class UserUtils {
    public static String hashPassword(String password) {
        return  BCrypt.hashpw(password, BCrypt.gensalt());
    }
    public static boolean checkPassWord(String password, String hashedPassword) {
        boolean checkPwd = false;
        if (BCrypt.checkpw(password, hashedPassword)) checkPwd = true;
            return checkPwd;
    }
}
