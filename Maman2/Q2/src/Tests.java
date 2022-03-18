public class Tests {

    public   void Run(){
        Rational x, y, z;
        // 1/2 + 1/3 = 5/6
        x = new Rational(1, 2);
        y = new Rational(1, 3);
        z = x.plus(y);
        System.out.println(z);

        // 8/9 + 1/9 = 1
        x = new Rational(8, 9);
        y = new Rational(1, 9);
        z = x.plus(y);
        System.out.println(z);

        //  5/6 * 6/5 = 1
        x = new Rational(5, 6);
        y = new Rational(6, 5);
        z = x.multiply(y);
        System.out.println(z);

        // 40/200 * 120/1000 = 3/125
        x = new Rational(40, 200);
        y = new Rational(120, 1000);
        z = x.multiply(y);
        System.out.println(z);

        // 40/200 * 120/1000 = 2/25
        x = new Rational(40, 200);
        y = new Rational(120, 1000);
        z = x.minus(y);
        System.out.println(z);


        // 40/200 / 120/1000 = 5/3
        x = new Rational(40, 200);
        y = new Rational(120, 1000);
        z = x.divide(y);
        System.out.println(z);


        z = x.reduce(40, 200);
        System.out.println(z);

    }
}
