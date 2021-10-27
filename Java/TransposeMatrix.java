import java.util.Scanner;
public class TransposeMatrix{
    public static void main(String args[])
    {
    int i, j;
    System.out.println("Enter the no. of rows and columns of the matrix: ");
    Scanner s = new Scanner(System.in);
    int row = s.nextInt();
    int column = s.nextInt();
    int mat[][] = new int[row][column];
    System.out.println("Enter the matrix:");
    for(i = 0; i < row; i++){
        for(j = 0; j < column; j++){
            mat[i][j] = s.nextInt();
            System.out.print(" ");
            }
    }
    System.out.println("The given matrix is: ");
    for(i = 0; i < row; i++){
        for(j = 0; j < column; j++){
            System.out.print(mat[i][j]+" ");
        }
        System.out.println(" ");
    }
    System.out.println("The transpose of the given matrix is: ");
    for(i = 0; i < column; i++){
        for(j = 0; j < row; j++){
            System.out.print(mat[j][i]+" ");
        }
        System.out.println(" ");
        }
    }
}