

/*
3a, 3b, 3,d, 3e skriv grensesnittet TilUtlaan
En ting som kan lånes ut skal kunne få en utlåner (identifisert av en String) og den skal kunne leveres tilbake. Diskuter (med deg selv og gjerne med andre og lag en fornuftig og nøyaktig beskrivelse av semantikken TilUtlaan slik som du synes dette grensesnitter bør være. Skriv JavaDoc-kommentarer som beskriver denne semantikken. Kjør javadoc-kommandoen og se at du får et bra dokument. Du skal ikke levere dette dokumentet. 
*/

interface TilUtlaan {

    public void setUtlåner(String utlånerNavn);
    public boolean levere(Bok b); 
    public laane();

}



