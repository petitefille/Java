import java.util.Scanner;

public class Task1 
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Write something: ");
        while (in.hasNext())
        {
            String input = in.next();
            printString(input);
        }        
        
    }

    public static void printString(String input)
   {
        System.out.println(input);
   }
}
    
