package insertionsort;

public class InsertionSort { 
    public static void insertionSort(int array[]) {  
        int m = array.length;  
        for (int k = 1; k < m; k++) {  
            int ky = array[k];  
            int b = k-1;  
            while ( (b > -1) && ( array [b] > ky ) ) {  
                array [b+1] = array [b];  
                b--;  
            }  
            array[b+1] = ky;  
        }  
    }  
       
    public static void main(String a[]){    
        int[] arr = {5,3,48,77,100,978,23,1,233,4,41};    
        System.out.println("Your Entered Array");    
        for(int i:arr){    
            System.out.print(i+" ");    
        }    
        System.out.println();    
            
        insertionSort(arr)  
           
        System.out.println("Sorting Aftre Array");    
        for(int i:arr){    
            System.out.print(i+" ");    
        }    
    }    
}    
