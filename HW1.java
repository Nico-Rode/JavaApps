/**
 * Created by Nico on 1/3/2017.
 */
import java.util.Scanner;

public class HW1 {
    public static void main(String[] arg)
    {
        //System.out.print(odd_even(1));
        //area_Circle();
        //int_convert();
        body_mass_index();

    }

    public static int odd_even(int number)
    {
        return number%2;
    }

    public static void area_Circle()
    {
        double pi = 3.14;
        System.out.print("Enter the radius of the circle:\n");
        Scanner input = new Scanner(System.in);
        double x = input.nextDouble();
        double area = x*x*pi;
        System.out.print("The area of the circle is: ");
        System.out.print(area);
    }

    public static void int_convert()
    {
       char[] charArray = {'A','B','C','a','b','c','0','1','2','$','*','+','/'};

       for (char character : charArray)
           System.out.printf("The integer representation of %c is %d\n", character, (int)character);
    }

    public static void body_mass_index()
    {
        System.out.print("Enter your weight in lbs: ");
        Scanner input = new Scanner(System.in);
        Scanner inputWeight = new Scanner(System.in);
        double userWeight = input.nextDouble();
        System.out.print("Enter your height in inches: ");
        Scanner inputHeight = new Scanner(System.in);
        double userHeight = input.nextDouble();

        double userBMI = (userWeight * 703)/(userHeight*userHeight);

        System.out.print("BMI VALUES\n");
        System.out.print("Underweight:  less than 18.5\n");
        System.out.print("Normal:   between 18.5 and 24.9\n");
        System.out.print("Overweight:   between 25 and 29.9\n");
        System.out.print("Obese:    30 or greater\n");
        System.out.printf("Your BMI is:     ");
        System.out.print(userBMI);

    }
}


