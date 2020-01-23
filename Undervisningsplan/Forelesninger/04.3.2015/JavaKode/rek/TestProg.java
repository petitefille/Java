class TestProg {

    public static void main (String[] argumenter) {
	LenkeListe<String> beholder = new LenkeListe<String>();
	for (String s: argumenter) {
	    beholder.settInnForan(s);
	}

	beholder.skrivUtInfoOmAlleObjekteneILista();
        System.out.println("------------------------");
        beholder.skrivUtInfoOmAlleObjekteneIListaXXX();
        System.out.println("------------------------");
        beholder.skrivUtInfoOmAlleObjekteneILista2();
        
    }
}

/*
[emilyd@fingon rek]$ java TestProg en to tre fire fem
Setter inn et objekt av klassen java.lang.String: en
Setter inn et objekt av klassen java.lang.String: to
Setter inn et objekt av klassen java.lang.String: tre
Setter inn et objekt av klassen java.lang.String: fire
Setter inn et objekt av klassen java.lang.String: fem
skrivUtDenneNodenOgResten kalt i node nr 5
fem, objekt av klassen java.lang.String
skrivUtDenneNodenOgResten kalt i node nr 4
fire, objekt av klassen java.lang.String
skrivUtDenneNodenOgResten kalt i node nr 3
tre, objekt av klassen java.lang.String
skrivUtDenneNodenOgResten kalt i node nr 2
to, objekt av klassen java.lang.String
skrivUtDenneNodenOgResten kalt i node nr 1
en, objekt av klassen java.lang.String
skrivUtDenneNodenOgResten i node nr 1 avslutter
skrivUtDenneNodenOgResten i node nr 2 avslutter
skrivUtDenneNodenOgResten i node nr 3 avslutter
skrivUtDenneNodenOgResten i node nr 4 avslutter
skrivUtDenneNodenOgResten i node nr 5 avslutter
------------------------
fem, objekt av klassen java.lang.String
fire, objekt av klassen java.lang.String
tre, objekt av klassen java.lang.String
to, objekt av klassen java.lang.String
en, objekt av klassen java.lang.String
------------------------
skrivUtRestenTilSluttDenneNoden kalt i node nr 5
skrivUtRestenTilSluttDenneNoden kalt i node nr 4
skrivUtRestenTilSluttDenneNoden kalt i node nr 3
skrivUtRestenTilSluttDenneNoden kalt i node nr 2
skrivUtRestenTilSluttDenneNoden kalt i node nr 1
en, objekt av klassen java.lang.String
skrivUtRestenTilSluttDenneNoden i node nr 1 avslutter
to, objekt av klassen java.lang.String
skrivUtRestenTilSluttDenneNoden i node nr 2 avslutter
tre, objekt av klassen java.lang.String
skrivUtRestenTilSluttDenneNoden i node nr 3 avslutter
fire, objekt av klassen java.lang.String
skrivUtRestenTilSluttDenneNoden i node nr 4 avslutter
fem, objekt av klassen java.lang.String
skrivUtRestenTilSluttDenneNoden i node nr 5 avslutter

*/

