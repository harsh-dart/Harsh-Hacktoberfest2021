#include<stdio.h>
void
main ()
{
  int i, orignum, num, lastdigit, sum;
  long fact;
  printf ("enter the number");
  scanf ("%d", &num);
  orignum = num;
  sum = 0;
  while (num > 0)
    {
      lastdigit = num % 10;
      fact = 1;
      for (i = 1; i <= lastdigit; i++)
	{
	  fact = fact * i;
	}
      /*add factorial to sum */
      sum = sum + fact;
      num = num / 10;
      /*check strong number condition */
    }
  if (sum == orignum)
    {
      printf ("%d is a strong number", orignum);

    }
  else
    {
      printf ("not strong");
    }

}

