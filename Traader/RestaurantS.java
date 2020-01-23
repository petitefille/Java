public class RestaurantS {
    RestaurantS(String[] args) {
	    int antall = Integer.parseInt(args[0]); //antall porsjoner
		FellesBord bord = new FellesBord();
		Kokk kokk = new Kokk(bord, antall);
		kokk.start();
		Servitor servitor = new Servitor(bord,antall);
		servitor.start();
	}    
    public static void main(String[] args) {
	    new RestaurantS(args);
	}	
	
}