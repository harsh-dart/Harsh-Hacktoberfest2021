import java.util.Scanner;
import java.lang.Math;

public class IntergerRead {

    void rev() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number:");
        long num = sc.nextLong();
        long ten = 10;

        int count = 0;
        long rev = 0;
        long rem = 0;
        long temp = num;
        while (temp > 0) {
            temp /= 10;
            count++;
        }
        temp = count;
        while (num > 0) {
            rem = num % 10;
            rev += rem * Math.pow(10, count - 1);
            count--;
            num /= 10;
        }

        String ar[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        while (temp > 0) {
            System.out.print(ar[(int) (rev % 10)] + " ");
            rev /= 10;
            temp--;
        }
    }

    public static void main(String args[]) {
        IntergerRead obj = new IntergerRead();
        obj.rev();
    }

}
