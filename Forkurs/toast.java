import java.util.LinkedList;
import java.util.ListIterator;
public class Toast {
    public static void main(String[] args){
        LinkedList<String> alphabet = new LinkedList<String>();
        alphabet.add("A","B","C","D","E","F","G","H");
        ListIterator<String> iterator = alphabet.listIterator(); 
        while (iterator.hasNext())
        {
            String letter = iterator.next();
            System.out.println(letter);
        }
    }
}
  
