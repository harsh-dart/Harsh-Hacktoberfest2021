package bsort;

public class Bsort { 
    static void bsort(int[] arr) {  
        int x = arr.length;  
        int tmp = 0;  
         for(int i=0; i < x; i++){  
                 for(int k=1; k < (x-i); k++){  
                          if(arr[k-1] > arr[k]){   
                                 tmp = arr[k-1];  
                                 arr[k-1] = arr[k];  
                                 arr[k] = tmp;  
                         }  
                          
                 }  
         }  
  
    }  
    public static void main(String[] args) {  
                int ar[] ={2,46,88,930,47,100,353,18};  
                 
                System.out.println("Your Entered Array");  
                for(int i=0; i < ar.length; i++){  
                        System.out.print(ar[i] + " ");  
                }  
                System.out.println();  
                  
                bsort(ar); 
                 
                System.out.println("Sorting Array is:");  
                for(int i=0; i < ar.length; i++){  
                        System.out.print(ar[i] + " ");  
                }  
   
        }  
}  