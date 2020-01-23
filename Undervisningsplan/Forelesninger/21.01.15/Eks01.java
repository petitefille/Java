class Eks01{

    static int antallHunder;

    public static void main( String[] argumenter){
        Hund trofast = new Hund("Trofast");
        ++antallHunder;
        Hund pluto = new Hund("Pluto", 6750);
       ++antallHunder;
       System.out.println(antallHunder);
        
    }
}
