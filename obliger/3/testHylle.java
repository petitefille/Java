public class testHylleA 
{
    public static void main (String[] args)
   {
        Hylle<Bok> mittBokskap;
        mittBokskap = new Hylle<Bok>();
        Bok ChinuaAchuebe = new Bok("Things fall apart");
        mittBokskap.settInn(ChinuaAchuebe,6);
        Bok MargaretMitchell = new Bok("Gone by the wind");
        mittBokskap.settInn(MargaretMitchell, 88);
        mittBokskap.fjern(88);
        if (mittBokskap.inneholder(88) == true)
        {
            System.out.println("OK, har satt inn bok, tatt ut denne, og sjekket at plassen er ledig.");
        }
        else
        {
            System.out.println("FEIL, har satt inn bok, tatt den ut, og plassen er opptatt, men skulle ha vært ledig.");
        }

   }
}
