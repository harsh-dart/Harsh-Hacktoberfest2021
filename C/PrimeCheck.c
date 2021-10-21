#include<stdio.h>
void func(int x);
void main()
{
    int n;
    func(n);
}
void func(int x)
{
    scanf("%d",&x);
    for(int i=2;i<x;i++)
    {
        if(x%i==0)
        {
            printf("NOT prime");
            break;
        }
        else
        {printf("prime");
        break;
        }
    }
}
