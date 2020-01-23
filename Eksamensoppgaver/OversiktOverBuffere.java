class OversiktOverBuffere
{
	private OrdBuffer [] oversikt;
	
	public OversiktOverBuffere(int antall)
	{
        System.out.println("hei");
	this.oversikt = new OrdBuffer [antall-1];
         for (int i = 0; i < (antall-1); i++)
	{
	    OrdBuffer buffer = new OrdBuffer(i+1);
            this.oversikt[i] = buffer;
            System.out.println("Buffer" + i);		
	}
    }

    public void settInnOrdIBuffer(int arbeiderNr, String ord) throws InterruptedException
    {
		System.out.println(arbeiderNr + " her er jeg naa");
                System.out.println(arbeiderNr);
                if (this.oversikt[0] != null)
                {
                    System.out.println(arbeiderNr + " er ikke null");
                 }
                
		this.oversikt[arbeiderNr-1].ventHvisOrdBufferErFull();
                System.out.println(arbeiderNr + " Men naa er jeg her ");
		this.oversikt[arbeiderNr-1].settInnOrd(ord);
                System.out.println(arbeiderNr + " har satt inn ord i buffer");
	}
	public void settInnNullIBuffer(int arbeiderNr) throws InterruptedException	{
	       this.oversikt[arbeiderNr-1].ventHvisOrdBufferErFull();
		this.oversikt[arbeiderNr-1].settInnNull();
	}
	
	public String hentOrdFraForrigeOrdBuffer(int arbeiderNr) throws InterruptedException
	{
             System.out.println("Arbeider " + arbeiderNr + " er i klassen OversiktOverBuffere");
             
                 
	    this.oversikt[arbeiderNr-2].ventHvisOrdBufferErTom();
            System.out.println("Arbeider " + arbeiderNr + " er ferdig med aa vente paa at OrdBuffer er Tom");
		String ord = this.oversikt[arbeiderNr-2].taOrdFraForrigeOrdBuffer();
            System.out.println("Arbeider " + arbeiderNr + " 2 har hentet ord fra forrige buffer");
		return ord;
	}
	
		
	
}
