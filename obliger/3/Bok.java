class Bok {

    String tittel;
    Bok(String tt) {tittel = tt;}

    interface GenHylle<E> {
   
    public boolean settInn(E elem, int plass);
        
    public boolean inneholder(int plass);
    
    public void fjern(int plass);

    }

}
