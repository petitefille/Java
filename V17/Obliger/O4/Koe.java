//Skrevet av: Jonas Roppestad Olsen (Brukernavn: jonasrol)

class Koe<T> extends Lenkeliste<T>{ //Arver fra Lenkeliste<T>

  @Override //Overskriver settInn(T element) i Lenkeliste<T>
  public void settInn(T element){
    Node ny = new Node(element); //Lager en ny node med element som medsendt parameter

    if(erTom()){ //Hvis lista er tom
      foerste = ny; //Setter foerste til aa vaere ny
      siste = ny; //Setter siste til aa vaere ny
      return; //Avslutter metoden
    }

    //Hvis if-testen ikke inntreffer
    siste.neste = ny; //Setter siste sin neste til aa vaere ny
    ny.forrige = siste; //Setter ny sin forrige til aa vaere siste
    siste = ny; //Setter siste til aa vaere ny
  }
}