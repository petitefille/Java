import java.util.Scanner;

public class EvaluateNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = Integer.parseInt(sc.nextLine());
       
        if (num > 0) {
                System.out.println(num + " is greater than zero");
        } else if (num < 0) {
                System.out.println(num + " is less than zero");
        } else { 
                System.out.println(num + " is equal to zero!");
        }
    } // end main()
} // end class EvaluateNumber      

                


