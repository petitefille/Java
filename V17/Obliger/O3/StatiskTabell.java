//Skrevet av: Jonas Roppestad Olsen (Brukernavn: jonasrol)

import java.util.Iterator; //Importerer Iterator

class StatiskTabell<T> implements Tabell<T>{ //Implementerer Tabell<T>

  protected T[] tabell; //Generisk array som heter tabell
  protected int storrelse; //Antallet elementer i arrayen


  public StatiskTabell(int lengde){ //Konstruktoer for StatiskTabell
    tabell = (T[]) new Object[lengde]; //Oppretter en Object array og typekonverterer den til T[] med medsendt lengde
    storrelse = 0; //Initialiserer storrelse til aa vaere 0
  }


  public int storrelse(){ //Metode som returnerer antall elementer i arrayen
    return storrelse;
  }


  public boolean erTom(){ //Metode som sjekker om arrayen er tom
    return storrelse() == 0; //Hvis storrelse() er stoerre enn 0 saa returnerer den false, og true hvis den er tom
  }


  public void settInn(T element){ //Metode som setter inne et element i arrayen
    if(tabell[tabell.length - 1] != null){ //Hvis den siste plassen ikke er lik null
      throw new FullTabellUnntak(tabell.length); //Kaster nytt FullTabellUnntak
    }

    tabell[storrelse] = element; //Plasserer elementet i arrayen
    storrelse++; //Oeker antallet elementer med 1
  }


  public T hentFraPlass(int plass){ //Metode som henter element fra angitt plass
    if(storrelse() <= plass || plass < 0){ //Hvis storrelse() er mindre eller lik plass eller plass er mindre enn 0
      throw new UgyldigPlassUnntak(plass, storrelse()); //Kaster nytt UgyldigPlassUnntak
    }
    return tabell[plass]; //Returnerer elementet paa den angitte plassen
  }

  public Iterator<T> iterator(){ //Metode som returnerer en Iterator<T>
    return new TabellIterator(); //Returnerer ny TabellIterator
  }

 class TabellIterator implements Iterator<T>{ //Implementerer Iterator
  int plass; //Holder styr paa hvilken plass vi er paa

  public TabellIterator(){ //Konstruktoer for TabellIterator
    plass = 0; //Initialiserer plass til aa vaere 0
  }

  public boolean hasNext(){ //Metode som sjekker om det finnes et neste element
    return plass < storrelse(); //Hvis plass er mindre enn storrelse() returner true og false hvis den er lik eller stoerre
  }

  public T next(){ //Metode som returnerer det neste elementet
    if(hasNext()){ //Hvis hasNext() er true
      return tabell[plass++]; //Returner det neste elementet;
    }
    else{
      return null; //Returnerer null hvis det ikke er noen neste
    }
  }

  public void remove(){//Metode for aa fjerne element, men brukes ikke i denne oblige

  }
 }
}