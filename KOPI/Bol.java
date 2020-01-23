class Bol<T>
{
    private T beboer;

    public T beboer()
    {
        return beboer;
    }

    public T settInn(T beboer)
    {
        this.beboer = beboer;
        return beboer;  
    }
   
    public T taUt()
    {
        T nyBeboer = beboer;
        beboer = null;
        return nyBeboer;
    }
    
    public boolean tomt()
    {
       return (beboer == null);
    }
}   

