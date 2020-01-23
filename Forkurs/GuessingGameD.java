import java.util.Scanner;

public class GuessingGameD {
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

                        if (guess < 0 || guess > 100) { // (d)
				System.out.println("ERROR: " + guess + " is out of range! Try again");
				rounds--;
			} else if (guess == num) {
				System.out.println("Right answer :DDD hurray!");
			} else if (guess == num) {
				System.out.println("Right answer :DDD hurray!");
			} else {
				
				// (b)
				
				if (guess > num) {
					System.out.print(guess + " is greater than the answer.");
				} else {
					System.out.print(guess + " is less than the answer.");
				}
                                // (c)
				if ( (guess < num) && (guess > lowerBound) ) {
					lowerBound = guess;
				} else if ( (guess > num) && (guess < upperBound) ) {
					upperBound = guess;
				}
				System.out.print("The answer is between " + lowerBound + " and " + upperBound + ".");
				
				
				System.out.println(" " + (cntGuess - rounds) + " tries left.");
			}
			
		} while ((rounds < cntGuess) && (guess != num));
		
		if (guess != num) System.out.println("You dont have any tries left! The right answer was: " + num);
		
    } // end main()
} // end class GuessingGame

