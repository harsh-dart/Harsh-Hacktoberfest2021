class quicksort {



   static int partition(int a[],int s,int e){
        int i=s-1;
        int j=s;
        int pivot=a[e];
        for(;j<e;j++){
            if(a[j]<=pivot){
                i++;
                swap(a[j],a[i]);
            }
        }
        swap(a[i+1],a[e]);
        return i+1;
    }
   static void quicksort(int a[],int s,int e){
        if(s>=e){
            return;
        }
        int p=partition(a,s,e);
        quicksort(a,s,p-1);
        quicksort(a,p+1,e);
    }

    public static void main(String args[])
    {
        int arr[] = { 12, 11,4,55 };

        quicksort ob = new quicksort();
        ob.quicksort(arr);
    }
} 