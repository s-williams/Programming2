import java.security.SecureRandom;
import java.util.Arrays;

/**
 * Helper Methods
 */
public class Helpers {

    public static boolean isAnagram(String str1, String str2){

        if(str1.length() != str2.length()) {return false;}

        char[] a, b;
        Arrays.sort(a = str1.toCharArray());
        Arrays.sort(b = str2.toCharArray());
        return Arrays.equals(a,b);
    }

    static final String AB = "abcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    public static String randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }
}
