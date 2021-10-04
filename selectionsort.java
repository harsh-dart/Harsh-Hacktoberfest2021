import java.util.Scanner;


public class Selectionsort {
    
    void func()
    {
    Scanner sc = new Scanner(System.in);
     int ar[] = new int[5];
    
     // step 1 input 
        System.out.println("Enter element in array");
        for (int i = 0; i < ar.length; i++)     
        {
            ar[i] = sc.nextInt();
            
        }
     // step 2
       for(int r=0 ; r<4 ;r++)
     {
         for (int c = r ; c <= 4 ; c++)
         {
             if(ar[r]>ar[c])
             {
                 int temp = ar[r];
                 ar[r]= ar[c];
                 ar[c]=temp;
             }     
         }
   
     }
     
     // step 3
        System.out.println("-------------Sorted -----------");
        for (int i = 0; i < ar.length; i++)
        {
            System.out.println(ar[i]);
            
        }
    }
    public static void main(String[] args) {
        
        Selectionsort obj = new Selectionsort();
        obj.func();
    }
}
