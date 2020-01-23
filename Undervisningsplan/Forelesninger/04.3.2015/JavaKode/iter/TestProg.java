class TestProg {

    public static void main (String[] argumenter) {

	LenkeListe<String> beholder = new LenkeListe<String>();
	for (String s: argumenter) {
	    beholder.settInnForan(s);
	}

	beholder.skrivUtInfoOmAlleObjekteneILista();

	System.out.println("Hei og hÃ¥");
	
	for (String s1: beholder) 
	    System.out.println(s1);
	
    }
}

