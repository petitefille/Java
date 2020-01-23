class TestSortertEnkelListe
{
   public static void main (String[] args)
   {
	           // Tester om man kan sette inn en Lege i SortertEnkelListe
               SortertEnkelListe<Leger> SortertEnkelListeLeger;
			   SortertEnkelListeLeger = new SortertEnkelListe<Leger>();
			   Leger l1 = new Leger("Dr. Dre");
			   SortertEnkelListeLeger.leggTil(l1);
			   Leger l2 = new Leger("Dr.Hus");
			   Leger l3 = new Leger("Dr.Cox");
			   Leger l4 = new Leger("Dr.Oz");
			   Leger l5 = new Leger("Dr.Phil");
			   SortertEnkelListeLeger.leggTil(l2);
			   SortertEnkelListeLeger.leggTil(l3);
			   SortertEnkelListeLeger.leggTil(l4);
			   SortertEnkelListeLeger.leggTil(l5);
			   
			  Iterator<Lik> legerIterator = SortertEnkelListeLeger.iterator();
			  Leger l = legerIterator.next();
			  System.out.println(l);
			  
			  // Leger l11 = 
			   //Leger l22 = SortertEnkelListeLeger.iterator();
			   //Leger l33 = SortertEnkelListeLeger.iterator();
			   //System.out.println(l11);
			   //System.out.println(l22);
			   //System.out.println(l33);
			   

			   
			   
			   // Tester om man kan sette inn en Person i SortertEnkelListe
			   //SortertEnkelListe<Personer> SortertEnkelListePersoner;
			   //SortertEnkelListePersoner = new SortertEnkelListe<Personer>();
			   //Personer p1 = new Personer("Jens Hans Olsen", 11223344556L);
               //p1.adresse("Storgata", "67", "5431");
			   //boolean a1 = SortertEnkelListeLeger.leggTil(p1);
			   
			   //
			   
			   
   }
}



