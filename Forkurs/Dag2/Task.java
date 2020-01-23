import java.util.Scanner;

public class Task
{
    public static double add(double x, double y)
    {
        double z = x + y;
        return z;
    }
    public static double subtract(double x, double y)
    public static double multiply(double x, double y)
    public static double divide(double x, double y)

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Write 2 numbers to calculate their sum, their subtraction, their multiplication and their division: ");
        double a = in.nextDouble();
        double b = in.nextDouble();
        System.out.println(add(a,b));
        System.out.println(subtract(a,b));
        System.out.println(multiply(a,b));
        System.out.println(divide(a,b));
    
    }
}
