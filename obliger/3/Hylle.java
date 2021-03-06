import java.util.Arrays;

/* generisk klasse Hylle som implementerer GenHylle ved hjelp av en array
*/
class Hylle<E> implements GenHylle<E> {
    @SuppressWarnings("unchecked") 

    private E[] hylle = (E[]) new Object[100];
    
    private int antall = 0;

    public boolean settInn(E elem, int plass)
    {
        if (plass-- <= 99 && hylle[plass--] == null)
        {
            hylle[plass--] = elem;
            antall ++;
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean inneholder(int plass)
    {
        return (hylle[plass--] == null);
    }
 
    public void fjern(int plass)
    {
        if (inneholder(plass--) != true)
        {
            hylle[plass--] = null;
            antall--;
        }
             
    }

}
