package test;

import java.security.SecureRandom;

/**
 * @author AbuKhleif
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
