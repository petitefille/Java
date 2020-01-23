import java.util.Scanner;

public class FibonacciNumbers9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a number n: ");
		int n = sc.nextInt();
		
		int pp = 1;
		int p = 1;
		System.out.print(pp + " " + p);
		
		int num = pp + p;
		while (num < n) {
			System.out.print(" " + num);
			pp = p;
			p = num;
			num = pp + p;
		}
		
		System.out.println("\nThe Fibonacci number closest to n=" + n + " is: " + p);
		
		System.out.print("Enter n to find the nth fibonacci number: ");
		int nth = sc.nextInt();
		
		pp = 1;
		p = 1;
		num = pp + p;
		for (int i = 2; i < nth; i++) {
			pp = p;
			p = num;
			num = pp + p;
		}
		System.out.println("The nth fibonacci number (n=" + nth + ") is: " + p);
	         
    } // end main()
} // end class FibonacciNumbers

