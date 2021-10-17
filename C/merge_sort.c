#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<limits.h>
#include<time.h>

void merge(int arr[], int p, int q, int r)
{
    int n1,n2,i,j,k;
    n1 = q - p + 1;
    n2 = r - q;

    int L[n1],R[n2];

    for (i=1; i <= n1; i++)
        L[i] = arr[p + i - 1];

    for (j=1; j <= n2; j++)
        R[j] = arr[q + j];

    L[n1 + 1] = INT_MAX;
    R[n2 + 1] = INT_MAX;
    i=1;
    j=1;

    for(k=p; k <= r; k++)
    {
        if(L[i] <= R[j])
        {
            arr[k]=L[i];
            i++;
        }
        else
        {
            arr[k]=R[j];
            j++;
        }
    }
}

void mergeSort(int arr[], int p, int r)
{
    if (p < r)
    {
        int q= floor((p + r) / 2);

        mergeSort(arr, p, q);
        mergeSort(arr, q + 1, r);

        merge(arr, p, q, r);
    }
}


int main()
{
    int n;
    printf("enter the size of array : ");
    scanf("%d",&n);

    int arr[n];

    srand(time(0));
    for(int i=1; i <= n; i++)
    {
        arr[i]= rand() % 100;
    }
    printf("Given array is \n");
    for (int i=1; i <= n; i++)
        printf("%d ", arr[i]);
    printf("\n");

    mergeSort(arr, 1, n );

    printf("\nSorted array is \n");

    for (int i=1; i <= n; i++)
        printf("%d ", arr[i]);
    printf("\n");


    return 0;
}
