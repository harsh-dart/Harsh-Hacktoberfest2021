#include <stdio.h>
void strongPasswordChecker(char pass[])
{
    char c,p=0,a=0,d=0,e=0;
    for(int i=0;i<x;i++)
{
    for(c=97;c<=122;c++)
    {
        if(p[i]==c)
        {
            a++;
        }
    }
}
    for(int i=0;i<x;i++)
{
    for(c=65;c<=90;c++)
    {
        if(p[i]==c)
        {
            d++;
        }
    }
}
    for(int i=0;i<x;i++)
{
    for(c='0';c<='9';c++)
    {
        if(p[i]==c)
        {
            e++;
        }
    }
}
if(a==0)
{
    printf("password should contain atleast one lower-case character\n");
}
if(d==0)
{
    printf("password should contain atleast one upper-case character\n");
}
if(e==0)
{
    printf("password must contain atleast one digit\n");
}
}
int main()
{
    char arr[20];
    printf("password should have a minumum of 6 characters and a muximum of 20\n");
    scanf("%s",arr);
    strongPasswordChecker(arr);
    return 0;
}

