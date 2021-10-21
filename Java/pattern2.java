package loops;
import java.util.Scanner;

public class Pattern2 {
	public static void main(String[] args) {
Scanner s=new Scanner(System.in);
int n=s.nextInt();
int a=1;
for(int i=1;i<=n;i++)
{
	for(int j=1;j<=n-i;j++)
	{
		System.out.print("  ");
	}
	for(int j=1;j<=i;j++)
	{
		System.out.print(a++ +"  ");
	}
	System.out.println();
}
}}
