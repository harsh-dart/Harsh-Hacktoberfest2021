import java.util.*;

public class FindElement {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int d = sc.nextInt();
        sc.close();
        for (int i = 0; i < n; i++) {
            if (arr[i] == d) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("-1");
    }
}