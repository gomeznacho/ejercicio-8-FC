package nachogom.security;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class SecurityConfig {

    public static String slt;
    static {
        try {
            slt = getSalt();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
    }

    public static MessageDigest md;
    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    public static String getSalt() throws NoSuchAlgorithmException, NoSuchProviderException{
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG", "SUN");
        byte[] sltB = new byte[16];
        secureRandom.nextBytes(sltB);
        return sltB.toString();
    }
    public static String getSecurePassword(String rawPassword, String salt){
        String hshPswrd = null;
        try{
            md.update(salt.getBytes());
            byte[] sltB = md.digest(rawPassword.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : sltB) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            hshPswrd = sb.toString();
        }catch(Exception e){
            e.printStackTrace();
        }
        return hshPswrd;
    }
}
