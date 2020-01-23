import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class Labyrint{
  private int rader; //antall rader
  private int kolonner; //antall kolonner
  private Rute[][] labyrint;  //2D-array for rutene i labyrinten
  private boolean minimalUt;
  private OrdnetLenkeliste<Utvei> utveier;

  private Labyrint(int rader, int kolonner){
    this.rader = rader;
    this.kolonner = kolonner;
    this.labyrint = new Rute[rader][kolonner]; //setter hvot mange rader og kolonner labyrint arrayen skal ha
    this.minimalUt = false; //true = minimalUtskrift er paa. false = minimalUtskrift er av
    this.utveier = null;
  }

  static public Labyrint lesFraFil(File fil) throws FileNotFoundException{
    Scanner sc = new Scanner(fil); //scanner som scanner en fil
    Labyrint l = null; //variabel for lagring av labyrint-objekt
    int rader = 0; //antall rader
    int kolonner = 0; //antall kolonner
    int radTeller = 0; //Teller hvilken rad vi befinner oss paa

    String linje = sc.nextLine(); //sier at linje skal vaere scanneren sin neste linje
    String[] linjeArray = linje.split(" "); //splitter linjen paa mellomrom og gjoer den til en array
    rader = Integer.parseInt(linjeArray[0]); //rader er lik den foerste plassen
    kolonner = Integer.parseInt(linjeArray[1]); //kolonner er lik den andre plassen
    l = new Labyrint(rader, kolonner); //l er et nytt labyrint-objekt

    while(sc.hasNextLine()){ //loekken som scanner hver linje i filen
      linje = sc.nextLine(); //linje er scanneren sin neste linje
      linjeArray = linje.split(""); //splitter linjen for hvert tegn
      for(int i = 0; i < kolonner; i++){
        if (linjeArray[i].equals(".")){ //hvis det naavaerende tegnet er "." (hvit rute/aapning)
          if (i == 0 || i == (kolonner - 1) || radTeller == 0 || radTeller == (rader - 1)){ //hvis den er paa en av kantene
            l.labyrint[radTeller][i] = new Aapning(l, i, radTeller); //opprett en ny aapning
          }else{
            l.labyrint[radTeller][i] = new HvitRute(l, i, radTeller); //ellers så oppretter den en ny hvit rute
          }
        }else{
          l.labyrint[radTeller][i] = new SortRute(l, i, radTeller); //hvis tenget ikke er ".", opprett en svart rute
        }
      }
        radTeller++; //oeker radTeller med 1
      }
      for(int rad = 0; rad < rader; rad++){ //for-loekke som gaar over antall rader
        for(int kol = 0; kol < kolonner; kol++){ //for-loekke som gaar over antall kolonner
          l.labyrint[rad][kol].settNaboer(); //metodekall som setter naboene til en angitt rute
        }
      }

      return l; //returnerer labyrinten
    }

    public OrdnetLenkeliste<Utvei> finnUtveiFra(int kol, int rad){ //metode som finner en utvei fra en angitt plass i labyrinten
      utveier = this.labyrint[rad-1][kol-1].finnUtvei();
      if(hentMinimalUt() && !utveier.erTom()){
        OrdnetLenkeliste<Utvei> minimal = new OrdnetLenkeliste<Utvei>();
        minimal.settInn(new Utvei("", 0));
        return minimal;
      }
      return utveier; //returnerer en OrdnetLenkeliste med utveier fra en angitt plass
    }

    @Override //Overskriver toString()
    public String toString(){ //metode som skriver ut labyrinten i terminalen med sine respektive tegn
      String lab = "";
        for (int rad = 0; rad < rader; rad++){
          for (int kol = 0; kol < kolonner; kol++){
            lab += Character.toString(labyrint[rad][kol].tilTegn()) + " ";
          }
          lab += "\n";
        }
        return lab;
    }

    public boolean[][] lagBoolskLab(){
      boolean[][] boolskLab = new boolean[rader][kolonner];

      for (int i = 0; i < rader; i++){
        for(int j = 0; j < kolonner; j++){
          if(labyrint[i][j] instanceof HvitRute){
            boolskLab[i][j] = true;
          }
          else{
            boolskLab[i][j] = false;
          }
        }
      }
      return boolskLab;
    }

    public void settMinimalUtskrift(){ //metode som endrer variabelen minimalUt til aa vaere true
      minimalUt = true;
    }

    public int hentRader(){ //returnerer antall rader
      return rader;
    }

    public int hentKol(){ //returnerer antall kolonner
      return kolonner;
    }

    public Rute hentRute(int kol, int rad){ //returnerer en rute paa en angitt plass i labyrinten
      return labyrint[rad][kol];
    }

    public boolean hentMinimalUt(){ //returnerer om variabelen minimalUt er true eller false. Brukes i rute
      return minimalUt;
    }

    public Liste hentUtveier(){
      return utveier;
    }

  }