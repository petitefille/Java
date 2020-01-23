import java.util.ArrayList;

class Regneklynge{
   private int noderPerRack;
   private ArrayList<Rack> rack = new ArrayList<Rack>();

   public Regneklynge(int noderPerRack){
     this.noderPerRack = noderPerRack;
     rack.add(new Rack(noderPerRack));
   }
   public void settInnNode(Node node){
     if(rack.get(rack.size()-1).erFull()){
       rack.add(new Rack(noderPerRack));
       rack.get(rack.size()-1).plasserNode(node);
     }
     else{
       rack.get(rack.size()-1).plasserNode(node);
     }
   }

   public double flops(){
     double flops = 0;
     for(int i = 0; i < rack.size(); i++){
       flops += rack.get(i).flopsR();
     }
    return flops;
   }

   public int sjekkMinne(int minneKrav){
     int noderNokMinne = 0;
     for(int i = 0; i < rack.size(); i++){
       if(rack.get(i).noderNokMinne(minneKrav) > 0){
         noderNokMinne += rack.get(i).noderNokMinne(minneKrav);
       }

     }
     return noderNokMinne;
    }

   public void info(int minne, int minne2, int minne3){
     System.out.println("Samlet FLOPS: " + flops());
     System.out.println("Noder med minst " + minne + "GB: " + sjekkMinne(minne));
     System.out.println("Noder med minst " + minne2 + "GB: " + sjekkMinne(minne2));
     System.out.println("Noder med minst " + minne3 + "GB: " + sjekkMinne(minne3));
     System.out.println("Antall rack: " + rack.size());
   }
}