#include <stdio.h>

int main()
{
    int n, s, sum = 0, temp;
    printf("enter the number=");
    scanf("%d", &n);
    temp = n;
    while (n > 0)
    {
        s = s % 10;
        sum = sum + (s * s * s);
        n = n / 10;
    }
    if (temp == sum)
        printf("armstrong  number ");
    else
        printf("not armstrong number");
    return 0;
}