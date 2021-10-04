import java.util.Scanner;
class positivenegative
{
  public static void main(String args[])
{
      Scanner sc = new Scanner(System.in);
      int ar[]=new int[10];
      System.out.println("Enter element in array");
       for(int i=0;i<ar.length;i++)
{

ar[i]=sc.nextInt();

}
int pos=0;
int neg=0;
for(int i=0;i<ar.length;i++)
{
if(ar[i]>0)
{
pos++;
}
else
{
neg++;
}

System.out.println("positive element :"+pos);
System.out.println("negative element :"+neg);
}
}


}