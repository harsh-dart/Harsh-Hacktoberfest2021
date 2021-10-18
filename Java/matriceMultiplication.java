public class matriceMultiplication {

    public static void main(String[] args) {
        // ans.length=no of rows
        int[][] x = { { 2, 2, 3 }, { 3, 2, 4 }, { 1, 3, 4 } };
        int[][] y = { { 3, 5, 7 }, { 4, 2, 1 }, { 3, 2, 1 } };
        int ans[][] = new int[x.length][y[0].length];

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < y.length; k++) {
                    sum = sum + x[i][k] + y[k][j];
                }
                ans[i][j] = sum;
            }

        }
        System.out.println("Left array");
        printArray(x);
        System.out.println("Right array");
        printArray(y);
        System.out.println("Answer array");
        printArray(ans);

    }

    static void printArray(int[][] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++)
                System.out.print(x[i][j] + "\t");
        }
        System.out.println();
    }
}
