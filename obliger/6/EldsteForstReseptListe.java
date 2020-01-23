class EldsteForstReseptListe extends EnkelReseptListe
{
    public void settInnBak(Resepter r) 
	{
	    Node<Resepter> n = new Node<Resepter>(r);
	    if (siste != null) 
		{
	        siste.neste = n;
	        n.neste = null;
	        siste = n;
	    }
	    else 
		{
	        siste = n;
	        forste = n;
	        n.neste = null;
		}
	    antall++;
    }

}

   