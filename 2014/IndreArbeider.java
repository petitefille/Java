class IndreArbeider extends Arbeider
{
	
Arbeider nummer 2 henter ord fra denne bufferen. Er det ingen ord i bufferen må arbeider 2 vente.
Arbeider 2 sin oppgave er å finne det nest minste ordet i filen, dvs. det minste ordet som kommer
fra arbeider 1. Alle andre ord sendes videre til arbeider 3 via bufferen mellom arbeider 2 og 
2
arbeider 3. Er denne bufferen full må arbeider 2 vente. Når arbeider 2 er ferdig (henter en nullpeker
fra bufferen), skriver den ut at (ved hjelp av System.out.println) den er nummer 2 og det
minste ordet den har sett, og sender en null-peker til det etterfølgende bufferen.