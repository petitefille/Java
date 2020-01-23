class TestEnkelReseptListe
{
   public static void main (String[] args)
   {
               EldsteForstReseptListe EldsteForstRespetListeResepter;
			   EldsteForstRespetListeResepter = new EldsteForstReseptListe();
			   Resept r1 = new Resept();
			   Resept r2 = new Resept();
			   EnkelReseptListe eRL = (EldsteForstReseptListe ) EldsteForstRespetListeResepter;
			   EldsteForstRespetListeResepter.settInnBak(r1);
			   EldsteForstRespetListeResepter.settInnBak(r2);
			   eRL.iterate();
			   eRL.finn(1);
			   
			   
			   
   }
}