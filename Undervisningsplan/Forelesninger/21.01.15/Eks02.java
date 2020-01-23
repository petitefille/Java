class Eks02 {
   
    public static void main(String[] args){
        int a = 0, b = 7;
        Heltall refa, refb;
        

        refa = new Heltall(0);
        refb = new Heltall(7);
        a = b; refa = refb;
        b = 8; refb.tall = 8;
        System.out.println("a=" + a + ",b=" + b + "refa.tall=" + refa.tall + "refb.tall=" + refb.tall);
   }
}

// a=7,b=8refa.tall8refb.tall8

