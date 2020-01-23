//INF 1010 Oblig2
//Skrevet av: Jonas Roppestad Olsen (Brukernavn: jonasrol)

import java.util.ArrayList; //importerer ArrayList-verktoeyet
import java.util.Scanner; //importerer Scanner-verktoeyet
import java.io.*; //importerer io-biblioteket eller noe?

class Bilhierarki{
  public static void main(String[] args) {

    ArrayList<Bil> biler = new ArrayList<Bil>(); //Oppretter en ArrayList som holder paa biler

    try{ //programmet proever paa dette
      File file = new File(args [0]); //lager en ny File med filnavnet
      Scanner sc = new Scanner(file); //Lager en ny scanner som scanner filen


      while(sc.hasNextLine()){ //loekke som kjoerer saa lenge den har en linke aa lese
        String linje = sc.nextLine(); //lagrer den naavaerende linjen i en string
        String[] arrayAvLinje = linje.split(" "); //lager en String-array av linje som er delt ved mellomrom
        String regNummer = arrayAvLinje[1]; //Setter regNummer til aa vaere lik den andre plassen i arrayen

        if(arrayAvLinje[0].equals("LASTEBIL")){ //hvis linjen starter med LASTEBIL
          double utslipp = Double.parseDouble(arrayAvLinje[2]); //Gjoer om String til double
          double nyttevekt = Double.parseDouble(arrayAvLinje[3]); //Gjoer om String til double

          biler.add(new Lastebil(regNummer, utslipp, nyttevekt)); //Lager og legger inn et nytt Lastebil objekt i arrayen
        }

        else if(arrayAvLinje[0].equals("PERSONBIL")){ //Hvis linjen starter med PERSONBIL
          double utslipp = Double.parseDouble(arrayAvLinje[2]); //Gjoer om String til double
          int antallSeter = Integer.parseInt(arrayAvLinje[3]); //Gjoer om string til int

          biler.add(new Personbil(regNummer, utslipp, antallSeter)); //Lager og legger til et nytt Personbil objekt i arrayen
        }

        else if(arrayAvLinje[0].equals("EL")){ //Hvis linjen starter med EL
          double batteri = Double.parseDouble(arrayAvLinje[2]); //Gjoer om String til double

          biler.add(new Elbil(regNummer, batteri)); //Lager og legger til et nytt Elbil objekt i arrayen
      }
    }
  }catch(FileNotFoundException f){ //Hvis brukeren skriver inn et ugyldig filnavn
    System.out.println("Denne filen finnes ikke."); //Skriver ut at filen ikke finnes
  }


    try{
      String filter = args[1]; //Setter filter til aa vaere den andre plassen i String[] args
      printBilerFiltrert(filter, biler); //Kaller paa metoden som filtrerer biler i arrayen og sender med filter og arrayen

      if(!filter.equals("FOSSIL") && !filter.equals("EL")){ //Hvis brukeren skriver inn et ugyldig filter
        System.out.println("Vennligst bruk et gyldig filter: EL, FOSSIL"); //Brukeren om aa bruke et gyldig filter
      }
    }catch(IndexOutOfBoundsException i){ //hvis brukeren ikke skriver noe filter
      printAlleBiler(biler); //kaller paa metoden som printer info om alle biler og sender med arrayen som parameter
    }
  }

  public static void printAlleBiler(ArrayList<Bil> biler){ //printer info om alle bilene
    for(Bil b : biler){ //for-loop som gaar igjennom arrayen
      b.printInfo(); //kaller printInfo() paa objektet
      System.out.println(""); //Skriver en tom linje for aa faa luft i utskriften
    }
  }

  public static void printBilerFiltrert(String filter, ArrayList<Bil> biler){ //printer info basert paa filter
    for(Bil b : biler){ //for-loop som gaar igjennom arrayen
      if(filter.equals("EL")){ //Gjoer dette hvis filteret er EL
        if(b instanceof Elbil){ //Hvis objektet er av typen Elbil
          b.printInfo(); //print bilens info
          System.out.println(""); //skriv en tom linje for aa faa luft i utskriften
        }
      }
      else if(filter.equals("FOSSIL")){ //Gjoer dette hvis filteret er FOSSIL
        if(b instanceof Fossil){ //Hvis objektet er av typen Fossil
          b.printInfo(); //skriv ut bilens info
          System.out.println(""); //skriv en tom linje for aa faa luft i utskriften
        }
      }
    }
  }
}


/*


[emilyd@sudur O2]$ java Bilhierarki biler.txt
Type motorvogn:    Elbil
Reg.nr: EK43536
Batterikapasitet: 31.5kWh

Type motorvogn:    Lastebil
Reg.nr: SR87875
CO2-utslipp: 452.5 g/km
Nyttevekt: 2550.4 kg

Type motorvogn:    Personbil
Reg.nr: AR34345
CO2-utslipp: 119.5 g/km
Antall seter: 8

Type motorvogn:    Elbil
Reg.nr: EL14545
Batterikapasitet: 60.0kWh

Type motorvogn:    Personbil
Reg.nr: DK65437
CO2-utslipp: 135.7 g/km
Antall seter: 4

*/