#include<stdio.h>
void main()
{
    int n;
    scanf("%d",&n);
    int z=n;
    int v=0,i=1;
    while(n!=0)
    {
        z=n%2;
        n=n/2;
        v=v+(z*i);
        i=i*10;
    }
    printf("%d",v);
}
