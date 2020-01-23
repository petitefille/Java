class HundeBur {

    private Hund hundIBur = null;

    public void settInnHund(Hund h){
        if(hundIBur == null) hundIBur = h;
        else System.out.println("Hundeburet er fullt!");
    }

    public Hund taUtHund(){
        Hund somSlipperUt = null;
        if (hundIBur == null) System.out.println("Hundeburet er tomt!");
        else {
            somSlipperUt = hundIBur;
            hundIBur = null;
        }
        return somSlipperUt;
    }
}


