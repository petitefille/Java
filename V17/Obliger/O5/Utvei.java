class Utvei implements Comparable<Utvei>{

  private String vei;
  private int antFlytt;

  public Utvei(String vei, int antFlytt){
    this.vei = vei;
    this.antFlytt = antFlytt;
  }


  @Override
  public int compareTo(Utvei annen){
    return this.antFlytt - annen.hentAntFlytt();
  }

  public String hentVei(){
    return vei;
  }

  public int hentAntFlytt(){
    return antFlytt;
  }
}