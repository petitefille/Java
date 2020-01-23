interface Utlaan<T>{

    public void levere(Bok b);
/** 
* Metoden "levere" gjør at objektet tar vare på boken som   
*  er parameteren til metoden
*/

   

    public Bok laane(String navn);
/**
* Metoden "laane" sletter fra objektet en av bøkene som 
* tidligere var satt inn. Metoden returnerer boken som lånes
*/


}
