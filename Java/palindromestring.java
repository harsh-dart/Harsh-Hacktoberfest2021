import java.util.Scanner;

class PallindromeString {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String:");
        String str1 = sc.next();
        String str2 = "";
        for (int i = str1.length() - 1; i >= 0; i--) {
            str2 += str1.charAt(i);
        }
        if (str1.equalsIgnoreCase(str2)) {
            System.out.println(str1 + " is a pallindrome.");
        } else {
            System.out.println(str1 + " is not a pallindrome.");
        }
    }
}