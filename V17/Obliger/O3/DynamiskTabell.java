//Skrevet av: Jonas Roppestad Olsen (Brukernavn: jonasrol)

class DynamiskTabell<T> extends StatiskTabell<T>{ //Arver fra StatiskTabell<T>

  public DynamiskTabell(int lengde){ //Konstruktoer for DynamiskTabell
    super(lengde); //Kaller paa superklassen sin Konstruktoer og sender med lengden som parameter
  }

  public DynamiskTabell(){ //En annen konstruktoer for DynamiskTabell uten parameter
    super(100); //Kaller paa superklassen sin konstruktoer med 100 som standardverdi for arrayen
  }

  @Override //Overskriver settInn(T element) i StatiskTabell
  public void settInn(T element){ //Metode som setter inn et element i arrayen
    if(tabell.length == storrelse()){ //Hvis lengden paa tabellen er lik storrelse
      //Lag en ny array av typen Object og typekonverterer den til aa vaere
      //generisk med dobbel lengde som tabell
      T[] temp = (T[]) new Object[tabell.length * 2]; //Lag en ny tabell av typen
      for(int i = 0; i < tabell.length; i++){ //For-loekke som kopierer over fra tabell til temp
        temp[i] = tabell[i];
      }
      tabell = temp; //Setter tabell til aa vaere temp
    }

    tabell[storrelse()] = element; //Plasserer elementet i den oppdaterte tabellen
    storrelse++; //Oeker storrelse med 1
  }
}