class Rack{

  private Node[] noder; //Oppretter et array som holder paa noder, men med et foreloepig ukjent antall plasser
  private int nodePlass; //Holder styr paa hvilken plass i arrayen vi befinner oss paa
  private boolean full = false; //Sier om arrayen er fullt

  //Konstruktoer for Rack som har med antall plasser i arrayen som parameter
  public Rack(int antNoder){
    //Sier hvor mange plasser som arrayen skal ha
    noder = new Node[antNoder];
    //Setter nodePlass til aa vaere 0
    nodePlass = 0;
  }
//Metode for aa plassere den medsendte noden i arrayet
public void plasserNode(Node node){
  if(nodePlass == noder.length-1){ //Sjekker om vi er paa den siste plassen i arrayen
    //Hvis det stemmer, saa plasserer den noden paa den plassen og setter full til aa vaere true, siden den er fylt opp
    noder[nodePlass] = node;
    full = true;
  }
  else{
    //Hvis det ikke skulle stemme, saa plasserer den noden paa den naaverende plassen
    noder[nodePlass] = node;
  }
  //Oeker noderPlass med 1 etter at metoden er ferdigkjoert
  nodePlass++;
}

  //Returnerer om arrayet er fullt eller ikke for en sjekk i Regneklynge
  public boolean erFull(){
    //Returnerer full
    return full;
  }

  //Sjekker hvor mange noder som moeter kravet og returnerer antallet
  public int noderNokMinne(int minneKrav){
    //Oppretter en variabel for aa holde paa antallet noder som moeter kravet
    int nokMinne = 0;
    //En for-loop som gaar igjennom arrayen
    for(int i = 0; i < noder.length; i++){
      //Sjekker om plassen er fylt og sjekker om nodens minne stemmer med kravet
      if (noder[i] != null && noder[i].hentMinne() >= minneKrav){
        //Oeker nokMinne med 1
        nokMinne++;
      }
    }
    //Returnerer nokMinne
    return nokMinne;
  }

  //Legger sammen nodenes FLOPS og returnerer den
  public double flopsR(){
    double flops = 0;
    //En for-loop som gaar igjennom arrayen
    for(int i = 0; i < noder.length; i++){
      //Sjekker at plassen er fylt
      if(noder[i] != null){
        //Hvis plassen er fylt saa legger den til nodens FLOPS
        flops += noder[i].flopsN();
      }
    }
    //Returnerer flops
    return flops;
  }
}