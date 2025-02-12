
package Util;


import org.mindrot.jbcrypt.BCrypt;


public class PasswordEncryption {
    
   public static String encryptionPassword(String plainPassword){
       String hashedPassword=BCrypt.hashpw(plainPassword, BCrypt.gensalt());
       return hashedPassword;
   }
}
