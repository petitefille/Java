class Prosessor{

  private double frekvens; //en double variabel som holder paa frekvensen
  private int kjerner; // en int variabel som holder paa antall kjerner

  public Prosessor(double frekvens, int kjerner){ //konstruktoer
    this.frekvens = frekvens; //setter klassens frekvens til aa vaere lik parameteren
    this.kjerner = kjerner; //setter klassens kjerner til aa vaere lik parameteren
  }

  public double flopsP(){ //renger ut prosessorens FLOPS
    double flops;
    flops = frekvens * kjerner * 8;
    return flops;
  }
}