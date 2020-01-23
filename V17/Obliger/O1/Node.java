class Node{

  private Prosessor[] prosessorer = new Prosessor[2]; //Oppretter en Prosessor array med to plasser
  private int minne; //En int variabel som holder paa nodens minne

  //konstruktoer for 1 prosessor
  public Node(int minne, double frekvens, int kjerner){
    //Setter klassens minne til aa vaere lik den medsendte parameteren
    this.minne = minne;
    /*Setter den foerste plassen i arrayen til aa vaere en ny prosessorer og sender med frekvens og antall kjerner
    som parametere til prosessorens konstruktoer*/
    prosessorer[0] = new Prosessor(frekvens, kjerner);

  }
  //Konstruktoer for 2 prosessorer. Gjoer nesten akkurat det samme som den foerste
  public Node(int minne, double frekvens, int kjernerP1, int kjernerP2){
    this.minne = minne;
    prosessorer[0] = new Prosessor(frekvens, kjernerP1);
    prosessorer[1] = new Prosessor(frekvens, kjernerP2);
  }

  //Returnerer nodens minne
  public int hentMinne(){
    return minne;
  }

  //Legger sammen prosessorenes FLOPS og returnerer den
  public double flopsN(){
    //En double variabel som skal holde paa den samlede FLOPSen til prosessorene
    double flops;
    //Sjekker om det er det er noe paa den siste plassen i arrayen prosessorer
    if(prosessorer[1] == null){
      //Hvis dette stemmer saa henter den kun FLOPS fra den prosessoren og setter flops til aa vaere lik den
      flops = prosessorer[0].flopsP();
      //Returnerer flops
      return flops;
    }
    //Hvis det er 2 prosessorer, saa henter den FLOPS fra begge, legger dem sammen og setter flops til aa vaere lik summen
      flops = prosessorer[0].flopsP() + prosessorer[1].flopsP();
      //Returnerer flops
      return flops;
  }
}