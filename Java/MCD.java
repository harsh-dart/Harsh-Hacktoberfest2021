/* Euclid's MCD
 * This algorithm helps finding MCD, using divisor (that is the lower number)\
 *  and the ratio between higher and lower number. This is done recursively.
 * a -> major numbers   b -> minor number  a%b ratio  [first step]
 * b as a   b as a%b [next steps]
 *
 * Author: LordRibblesdale
 * Method: recursive
 */

import java.util.Scanner;

public class MCD {
    public static long eul(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return eul(b, a%b);
        }
    }

    public static void main(String[] args) {
        long[] n = {0, 0};
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            System.out.printf("Insert number here (%d): ", i+1);
            do {
                if (n[i] < 0) {
                    System.out.printf("Exception: n[%d] is not positive.\nInsert again: ", i+1);
                }
                n[i] = in.nextLong();
            } while (n[i] < 0);
        }

        if (n[0] > n[1]) {
            System.out.print("MCD is: " + eul(n[0], n[1]));
        } else {
            System.out.print("MCD is: " + eul(n[1], n[0]));
        }
    }
}