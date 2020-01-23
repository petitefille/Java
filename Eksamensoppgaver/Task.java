class Task
{
	private int antallTraader;
	private String innfilNavn;
	private String utfilNavn;
	private OversiktOverBuffere oversikt;
	
	public Task(int antallTraader, String innFilnavn, String utFilnavn)
	{
		this.antallTraader = antallTraader;
		this.innfilNavn = innFilnavn;
		this.utfilNavn = utFilnavn;
		
	}
	
	public void begynn()
	{
		this.oversikt = new OversiktOverBuffere(antallTraader);
		
        		
		new ForsteArbeider(1, this.oversikt, this.innfilNavn).start();
		
       if (antallTraader > 2)
        {
            for (int i = 2; i < this.antallTraader; i++)
            {
                new IndreArbeider(i, this.oversikt).start();
                System.out.println("Samlebaand" + i);
            }
       }

/*	
        new SisteArbeider(this.antallTraader, this.oversikt, this.utfilNavn).start();
*/
	}
   
}
