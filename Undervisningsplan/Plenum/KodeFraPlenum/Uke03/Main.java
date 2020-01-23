public class Main {

    public static void main(String[] args) {

        Circle c1 = new Circle(3.0);
        Circle c2 = new Circle(4.0);

        PolygonTest<Circle> pt = new PolygonTest<Circle>();
        pt.test(c1, c2);
    }

}

/*
[emilyd@fingon Uke03]$ java Main
Areal c1: 28.274333882308138
Areal c2: 50.26548245743669
Omkrets c1: 18.84955592153876
Omkrets c2: 25.132741228718345
c1 er storst

*/
