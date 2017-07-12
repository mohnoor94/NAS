package samples;

import java.security.SecureRandom;

/**
 * @author AbuKhleif
 * This class cntains a simple method used in guru99 website tests..
 */
public class Guru99Helper {
    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static SecureRandom rnd = new SecureRandom();

    /**
     * Generate a random email
     *
     * @return String email
     */
    public String generateRandomEmail() {
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 11; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        sb.append("@example.com");
        return sb.toString();
    }
}
