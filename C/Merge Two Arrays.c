int * mergeArrays(int a[], int b[], int asize, int bsize) 
{
  int n,i,j,temp;
  n=asize+bsize;
    for(i=asize;i<n;i++)
    {
      a[i]=b[i-asize];
    }
  for(i=0;i<n;i++)
  {
    for(j=i+1;j<n;j++)
    {
      if(a[i]>a[j])
      {
        temp=a[j];
        a[j]=a[i];
        a[i]=temp;
      }
    }
  }
  return &a[0];
}
