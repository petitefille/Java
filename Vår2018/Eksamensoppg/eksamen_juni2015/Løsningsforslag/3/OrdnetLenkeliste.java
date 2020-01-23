class OrdnetLenkeliste  {
    public static void main (String[] args) {
        Liste <String> ordliste = new Liste<String>();
        String[] navn = new String[]
        { "I",  "dag", "er", "det", "eksamen", "i", "INF1010.\n",
        "Jeg", "håper", "du", "liker", "denne", "oppgaven.\n",
        "Lykke", "til!",  "hilsen",  "oppgaveforfatteren\n" };
        System.out.print("Setter inn: ");
        for (String  n : navn ) {
            System.out.print(n + " ");
            ordliste.settInn(n);
        }
        System.out.println();
        ordliste.skrivAlle();
        System.out.println();
    }
}


/*

[emilyd@isleworth 3]$ java OrdnetLenkeliste
Setter inn: I dag er det eksamen i INF1010.
 Jeg håper du liker denne oppgaven.
 Lykke til! hilsen oppgaveforfatteren
 
Alle i lista:
-----
I
INF1010.

Jeg
Lykke
dag
denne
det
du
eksamen
er
hilsen
håper
i
liker
oppgaveforfatteren

oppgaven.

til!
 --- SLUTT

*/
