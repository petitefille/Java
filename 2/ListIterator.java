public interface ListIterator<E>
{
    E fjernEldste();
   
    boolean tom();

    boolean leggTil(E e);

    void fjern();

    boolean inneholder(E e);

}
