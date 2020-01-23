import java.util.Scanner;

class TaskTwo
{
    public static double add(double x, double y)
    {
        double z = x + y;
        return z;
    }

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextDouble();
        System.out.println(add(a,b));
    
    }
}
