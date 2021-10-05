import java.util.*;

public class DuplicateElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int size = sc.nextInt();
        int[] arr = new int[size];
        int f[] = new int[size];

        for(int i = 0; i <arr.length; i++){
            arr[i] = sc.nextInt();
        }

        for(int i =0;i<arr.length; i++){
                f[arr[i]]++;
            }

        for(int i=0;i<arr.length;i++){
            if(f[arr[i]] > 1)
                System.out.println(arr[i]);
        }

    }
}
