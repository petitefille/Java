class Bur<T> {
    private T dyrIBur = null;

    public void settInn(T h) {
        if (dyrIBur == null) dyrIBur =h;
        else System.out.println("Buret er fullt!");
    }

    public T taUt() {
    T somSlipperUt = null;
    if (dyrIBur == null) System.out.println("Buret er tomt!");
    else {
        somSlipperUt = dyrIBur;
        dyrIBur = null;
    }
    return somSlipperUt;
  }
    
}
        
