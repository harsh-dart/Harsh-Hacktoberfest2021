package arrays;

import java.util.Scanner;

public class Determinantofmatrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Enter dimensions of matrix (Dimensions should be equal):  ");
		
		int rows = sc.nextInt();
		int cols = sc.nextInt();
			
		int mat[][] = new int[rows][cols];
			
		System.out.println("Enter matrix elements:  ");
			
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				mat[i][j] = sc.nextInt();		
			}
		}
		int res = determinantofMatrix(mat,rows);
		System.out.println(res);
		
	}
	
	//function for Co-factor
	public static void getcoFactor(int mat[][],int temp[][],int p,int q,int n) {
		int i = 0, j = 0;
		for(int row = 0; row < n; row++) {
			for(int col = 0; col < n; col++) {
				if(row != p && col != q) {
                    temp[i][j++] = mat[row][col];
                    if(j==n-1) {
                        j = 0; 
                        i++;
                    }
                }
			}
		}
	}
	
	//Function for finding determinant of matrix
	public static int determinantofMatrix(int matrix[][],int n) {
		int determinant = 0;
		if(n==1) {
			return matrix[0][0];
		}
		int temp[][] = new int[n][n];
		int sign = 1;
		for(int f = 0; f < n; f++) {
			getcoFactor(matrix,temp,0,f,n);
			determinant += sign*matrix[0][f]*determinantofMatrix(temp,n-1);
			sign = -sign;
		}
		return determinant;
	}
}


