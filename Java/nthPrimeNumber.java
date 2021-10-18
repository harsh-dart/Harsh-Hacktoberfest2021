// The following program will help us to display the nth Prime Number, as per the user's input.

import java.util.Scanner;  

public class nthPrimeNumber{  
  public static void main(String args[]){ 
    Scanner in = new Scanner(System.in);  
	System.out.print("Enter the value of n to display the nth Prime Number: ");  
	int n = in.nextInt();   
	int num = 1, count = 0;
    int i;
	  while (count < n){  
		num++;  
		for (i = 2; i <= num; i++){   
			if (num % i == 0)   
				break;  
	    }  
		if (i == num)    
			count++; 
	  }    
	System.out.println("The " + n + "th Prime Number is: " + num);  
  } 
}
