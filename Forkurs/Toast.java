import java.util.ListIterator;
import java.util.Scanner;
public class Toast {
    public static void main(String[] args){
        String Alphabet = "ABCDEFGH";
        for (int i = 0; i < Alphabet.length(); i++)
        {    
            char letter = Alphabet.charAt(i);
            System.out.println(letter);
            Scanner in = new Scanner(System.in);
            System.out.print("Write all the letters you have read: ");
            String user = in.next();
            String program = Alphabet.substring(0,i++);
            if (user == program)
            {
                System.out.println("Correct!");
            }
            else
            {
                System.out.println("Wrong!");
            }
        }        
    }
}
  
