import java.util.Scanner;
public class Tekst {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = in.next();
        System.out.print("Hei," + name + "!");
    }
}       
