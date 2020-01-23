//Skrevet av: Jonas Roppestad Olsen (Brukernavn: jonasrol)

class Stabel<T> extends Lenkeliste<T>{ //Arver fra Lenkeliste<T>

  @Override //Overskriver settInn(T element) i Lenkeliste<T>
  public void settInn(T element){
    Node ny = new Node(element); //Lager en ny node med element som medsendt parameter

    if(erTom()){ //Hvis lista er tom
      foerste = ny; //Setter foerste til aa vaere ny
      siste = ny; //Setter siste til aa vaere ny
      return; //Avslutter metoden
    }

    //Hvis if-testen ikke inntreffer
    foerste.forrige = ny; //setter foerste sin forrige til aa vaere ny
    ny.neste = foerste; //Setter ny sin neste til aa vaere foerste
    foerste = ny; //Setter foerste til aa vaere ny
  }
}