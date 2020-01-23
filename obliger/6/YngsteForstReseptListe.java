class YngsteForstReseptListe extends EnkelReseptListe
{
	public void settInnForan(Resepter r) 
	{
        Node<Resepter> n = new Node<Resepter>(r);
        n.neste = forste.neste;
        forste.neste = n;
        if ( siste.neste == n)
		{
			siste = n;
		}		
        antall++;
	}	

}


    
	
	