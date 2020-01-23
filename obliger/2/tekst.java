[emilyd@fingon 2]$ java Oblig2TestA
OK - tom() paa tom mengde returnerer true
OK - tom() paa ikke-tom mengde returnerer false
OK - inneholder() paa en tom mengde skal returnere false
OK - leggTil() med et nytt element skal returnere true
OK - inneholder() skal returnere false for elementer som ikke er i mengden
FEIL - inneholder() skal klare aa finne eldste element. Skulle vaert: true. Var: false
FEIL - inneholder() skal klare aa finne et element midt i mengden. Skulle vaert: true. Var: false
FEIL - inneholder() skal klare aa finne nyeste element. Skulle vaert: true. Var: false
FEIL - leggTil() med et eksisterende element skal returnere false. Skulle vaert: false. Var: true
OK - fjernEldste() paa en tom mengde skal returnere null
OK - fjernEldste() paa en mengde med ett element skal gi en tom mengde
FEIL - fjernEldste() skal returnere det forste objektet vi la inn. Skulle vaert: Hallo. Var: Tjolahopp!
Exception in thread "main" java.lang.NullPointerException
	at Mengde.fjernNyeste(Mengde.java:118)
	at Oblig2TestA.main(Oblig2TestA.java:53)

