class Oblig1{
  public static void main(String[] args) {
    Regneklynge abel = new Regneklynge(12);

    for(int teller = 0; teller < 650; teller ++){
      abel.settInnNode(new Node(64, 2.6E9, 8, 8));
    }
    for(int teller = 0; teller < 16; teller++){
      abel.settInnNode(new Node(1024, 2.3E9, 8, 8));
    }
    abel.info(32, 64, 128);
  }
}


/*

[emilyd@sudur O1]$ java Oblig1
Samlet FLOPS: 2.210304E14
Noder med minst 32GB: 666
Noder med minst 64GB: 666
Noder med minst 128GB: 16
Antall rack: 56


*/