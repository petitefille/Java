import java.util.Scanner;

public class GuessingGameB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a number between 0 and 100: ");
		int num = sc.nextInt();
	
		
		System.out.print("How many guesses? ");
		int cntGuess = sc.nextInt();
		
		int lowerBound = 0;
		int upperBound = 100;
		int guess = 0;
		
		int rounds = 0;
		do {
			rounds++;
			
			System.out.print("Guess a number: ");
			guess = sc.nextInt();
			
			if (guess == num) {
				System.out.println("Right answer :DDD hurray!");
			} else {
				
				// (b)
				
				if (guess > num) {
					System.out.print(guess + " is greater than the answer.");
				} else {
					System.out.print(guess + " is less than the answer.");
				}
				
				
				
				System.out.println(" " + (cntGuess - rounds) + " tries left.");
			}
			
		} while ((rounds < cntGuess) && (guess != num));
		
		if (guess != num) System.out.println("You dont have any tries left! The right answer was: " + num);
		
    } // end main()
} // end class GuessingGame

