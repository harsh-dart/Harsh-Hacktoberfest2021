public class cyclicsort{
  
  public static void main(string[] args){
    int arr[] = {3,5,2,1,4};
    cyclicSort(arr);
    System.out.println(Arrays.toString(arr));
  }
static void cyclicSort(int[] arr)
{
  int i=0;
  while(i<arr.length)
  {
    int correct = arr[i]-1;
    if(arr[i]==arr[correct])
    {
      i++;
    }
    else{
      swap(arr,i,correct);
    }
  }
}

static void swap(int[] arr,int a, int b){
  int temp = arr[a];
  arr[a]= arr[b];
  arr[b]=temp;
}
}
