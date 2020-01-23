public class testHylleA 
{

// test som setter inn bok, tar ut denne, og sjekker at plassen
// nå er ledig

    public static void main (String[] args)
   {
        Hylle<Bok> mittBokskap;
        mittBokskap = new Hylle<Bok>();
        Bok Bok1 = new Bok("Gone with the wind, Margaret Mitchell");
        mittBokskap.settInn(Bok1, 88);
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

/*
Terminal> java testHylleA
OK, har satt inn bok, tatt ut denne, og sjekket at plassen er ledig.
*/
