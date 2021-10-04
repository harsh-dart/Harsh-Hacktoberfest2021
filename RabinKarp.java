
import java.util.Scanner;
public class RabinKarp {
    public final static int digit = 256;
  
    static void search(String pattern, String text, int primenum)
    {
        int patlen = pattern.length();
        int txtlen = text.length();
        int i, j;
        int p = 0;
        int t = 0;
        int h = 1;
  
        for (i = 0; i < patlen - 1; i++)
            h = (h * digit) % primenum;
  
        for (i = 0; i < patlen; i++) {
            p = (digit * p + pattern.charAt(i)) % primenum;
            t = (digit * t + text.charAt(i)) % primenum;
        }
  
        for (i = 0; i <= txtlen - patlen; i++) {
  
            if (p == t) {
                for (j = 0; j < patlen; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j))
                        break;
                }
  
                if (j == patlen)
                    System.out.println("Pattern found at index NO " + i);
            }
  
            if (i < txtlen - patlen) {
                t = (digit * (t - text.charAt(i) * h) + text.charAt(i + patlen)) % primenum;
  
                if (t < 0)
                    t = (t + primenum);
            }
        }
    }
  
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Rabin Karp");
        System.out.println("Enter text string");
        String text = sc.nextLine();
        System.out.println("Enter pattern string");
        String pattern= sc.nextLine();
        int primenum = 101; 
        search(pattern, text, primenum);
    }
}
  
