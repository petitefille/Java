public class ArrayMain {
    public static void main(String[] args ) {
        int n = 11;
        String[] a = new String[n];
        for ( int i=0; i<5; i++ ) {
            new Thread( new ArrayTraad( i, 5, a) ).start();
        }

    }
}