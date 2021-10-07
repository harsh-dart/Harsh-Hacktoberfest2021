package practise_java;
import java.util.Scanner;
public class Days {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner s=new Scanner(System.in);
int day=s.nextInt();
String name;
switch(day)
{
case 1: name="monday";break;
case 2: name="tuesday";break;
case 3: name="wednesday";break;
case 4: name="thursday";break;
case 5: name="friday";break;
case 6: name="saturday";break;
case 7: name="sunday";break;
default:name="invalid";

}
System.out.println("the day is  " + name);
	}

}
