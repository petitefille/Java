//Skrevet av: Jonas Roppestad Olsen (Brukernavn: jonasrol)

import java.util.Iterator; //Importerer Iterator

public abstract class Lenkeliste<T> implements Liste<T>{ //Implementerer Liste<T>

  protected class Node<T>{ //Indre klasse

    protected Node neste; //Noden etter denne i lista
    protected Node forrige; //Noden foer denne i lista
    protected T data; //Det noden holder paa

     Node(T data){ //Konstruktoer for Node
      this.neste = null; //Setter noden sin neste til aa vaere null
      this.forrige = null; //Setter noden sin forrige til aa vaere null
      this.data = data; //Setter noden sin data til aa vaere den medsendte parameteren data
    }
  }

  protected Node foerste; //Den foerste noden i lista
  protected Node siste; //Den siste noden i lista

  Lenkeliste(){ //Kunstruktoer for Lenkeliste
    this.foerste = null; //Setter foerste til aa vaere null
    this.siste = null; //Setter siste til aa vaere null
  }

  public int storrelse(){ //Metode som returnerer antallet i lista
    Node temp = foerste; //Setter temp til aa vaere lik foerste
    int antall = 0; //Initialiserer antall til aa vare 0

    while(temp != null){ //Kjoerer saa lenge temp ikke er null
      temp = temp.neste; //Setter temp til aa vaere lik temp sin neste
      antall++; //Oeker antall med 1
    }
    return antall; //Returnerer antall
  }

  public boolean erTom(){ //Metode som sjekker om lista er tom
    if(foerste == null){ //Hvis foerste er lik null saa er lista tom
      return true; //Returnerer true
    }
    return false; //Returnerer false hvis den if-testen ikke inntreffer
  }

  public void settInn(T element){ //Setter inn et element i lista
    //Implementasjonen av denne metoden er overlatt til subklassene
  }

  public T fjern(){ //Metode som fjerner det foerste elementet i lista
    if(erTom()){ //Hvis metoden returnerer true
      return null; //Returner null for aa si at lista er tom
    }
    Node temp = foerste; //Setter temp til aa vaere det samme som foerste
    foerste = foerste.neste; //Setter foerste til aa vaere det samme som foerste sin neste


    if(foerste != null){ //if-test som inntreffer dersom foerste ikke er lik null
      foerste.forrige = null; //Setter foerste sin forrige til aa vaere null
    }
    return (T) temp.data; //Returnerer temp sin data
  }

  public Iterator<T> iterator(){ //Metode som returnerer en Iterator<T>
    return new Listeiterator<T>(); //Returnerer en ny Listeiterator<T>
  }

  protected class Listeiterator<T> implements Iterator<T>{ //Implementerer Iterator
    Node temp = new Node(null); //Iterator node

    Listeiterator(){
      temp.neste = foerste; //Setter temp til aa vaere det samme som foerste
    }

    public boolean hasNext(){ //Metode som sjekker om det finnes en neste node
      if(temp.neste != null){ //Hvis temp sin neste ikke er lik null
        return true; //Returner true
      }
      return false; //Hvis if-testen ikke inntreffer, saa returner false
    }

    public T next(){ //Metode som returnerer det neste elementet
      if(this.hasNext()){ //Hvis hasNext() returnerer true
        temp = temp.neste; //Setter temp til aa vaere lik temp sin neste
        return (T) temp.data; //Returnerer temp sin data
      }
      return null; //Hvis if-testen ikke inntreffer, saa returnerer den null
    }

    public void remove(){ //Metode som fjerner, men brukes ikke i denne obligen

    }
  }
}