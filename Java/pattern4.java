package loops;
import java.util.Scanner;
public class Pattern4 {
public static void main(String[]  args)
{
	Scanner s=new Scanner(System.in);
	int n=s.nextInt();
	for(int i=1;i<=n;i++)
	{
		for(char  j=97;j<=102;j++)
		{
			System.out.print(j+ "  ");
		}
		System.out.println();
	}
}
}
