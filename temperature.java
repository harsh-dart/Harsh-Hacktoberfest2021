package temperature;
 
 import java.util.Scanner;
  
public class Temperature {
    public static void main(String[] args){
     
        Scanner keyb = new Scanner(System.in);
        System.out.print("Please enter the initial temperature: ");
        double setC = keyb.nextDouble();
         
        Temperature temp = new Temperature(setC);
        System.out.print("The current temperature in Celsius is: " + temp.getC());
        System.out.print("The current temperature in Fahrenheit is: "  + temp.getF());
        System.out.print("The current temperature in Kelvin is: " + temp.getK());
    }
}
     
class temperatureC {
     
        double setC;
        temperatureC(double setC){
            this.setC = setC;
        }
         
        double getC()
        {
            return setC;
        }
         
        public double getF()
        {
            return ((double)9.0/5.0 * (setC + 32));
        }
         
        public double getK()
        {
            return (((double)5.0/9.0 * (setC - 32)) + 273.15);
        }
         
    }
