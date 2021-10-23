import java.util.Scanner;

public class BMICalculator {

   
   public static String bmiCategory(double weight, 
                                    double height) {

      
      double bmi = weight / ( height * height) ;

      
      if(bmi < 18.5)
         return "Thinness";
      else if(bmi < 25)
         return "Normal";
      else if(bmi < 30)
         return "Overweight";
      else
         return "Obese";
   }

   public static void main(String[] args) {

     
      double weightInKg = 0.0f;
      double heightInMeters = 0.0f;
      String result = null;

     
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter weight in Kg: ");
      weightInKg = scan.nextDouble();
      System.out.print("Enter height in meters: ");
      heightInMeters = scan.nextDouble();

     
      result = bmiCategory( weightInKg, 
                           heightInMeters );

      
      System.out.println(result);

      
      scan.close();
   }
}
