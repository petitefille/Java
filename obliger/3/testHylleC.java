public class testHylleC 

// test som setter inn bok, tar ut denne, og sjekker at plassen
// nå er ledig

{
    public static void main (String[] args)
   {
        Hylle<Bok> mittBokskap;
        mittBokskap = new Hylle<Bok>();
        Bok Bok3 = new Bok("Les Miserables, Victor Hugo");
        mittBokskap.settInn(Bok3,6);
        mittBokskap.fjern(6);
        if (mittBokskap.inneholder(6) == true)
        {
            System.out.println("OK, har satt inn bok, tatt ut denne, og sjekket at plassen er ledig.");
        }
        else
        {
            System.out.println("FEIL, har satt inn bok, tatt den ut, og plassen er opptatt, men skulle ha vært ledig.");
        }

   }
}

/*
Terminal> java testHylleC
OK, har satt inn bok, tatt ut denne, og sjekket at plassen er ledig.
*/
