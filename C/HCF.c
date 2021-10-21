#include<stdio.h>
void main()
{
    int a,b,hcf;
    scanf("%d %d",&a,&b);
    for(int i=1;i<=a&&i<=b;i++)
    {
        if(a%i==0&&b%i==0)
        {hcf=i;}
    }
    printf("%d",hcf);
}
