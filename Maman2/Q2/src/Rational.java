import java.util.Objects;

public class Rational implements Comparable<Rational>{
    private static Rational zero = new Rational(0,1);

    private int _numerator;
    private int _denominator; // the

    public  Rational(int numerator, int denominator){
        if(denominator <= 0){
            throw  new IllegalArgumentException("denominator is zero or less than zero");
        }
        int gcd = gcd(numerator, denominator);
        _numerator =  numerator / gcd;
        _denominator = denominator / gcd;

    }

    public int getNumerator(){return  _numerator;}
    public  int getDenominator(){return  _denominator;}


    @Override
    public String toString() {
        if(_denominator == 1) return _numerator + "";
        else                  return _numerator + "/" + _denominator;
    }


    @Override
    public int compareTo(Rational b) {
        Rational a = this;
        int lhs = a._numerator * b._denominator;
        int rhs = a._denominator * b._numerator;
        return Integer.compare(lhs, rhs);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rational rational = (Rational) o;
        return _numerator == rational._numerator && _denominator == rational._denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_numerator, _denominator);
    }

    public Rational plus(Rational b) {
        Rational a = this;

        // special cases
        if (a.compareTo(zero) == 0) return b;
        if (b.compareTo(zero) == 0) return a;

        int commonDenominator = _denominator * b.getDenominator();
        int numerator1 = _numerator * b.getDenominator();
        int numerator2 = b.getNumerator() * _denominator;
        int sum = numerator1 + numerator2;

        return new Rational (sum, commonDenominator);
    }

    public Rational reciprocal ()  {
        return new Rational (_denominator, _numerator);
    }

    public Rational minus(Rational b) {
        Rational a = this;
        return a.plus(b.negate());
    }

    private Rational negate() {
        return new Rational(-_numerator, _denominator);
    }

    public Rational multiply(Rational b) {
        Rational a = this;

        Rational c = new Rational(a._numerator, b._denominator);
        Rational d = new Rational(b._numerator, a._denominator);
        return new Rational(c._numerator * d._numerator, c._denominator * d._denominator);
    }

    public Rational divide (Rational b)  {
        Rational a = this;
        return a.multiply (b.reciprocal());
    }


    public   Rational reduce(int numerator, int denominator) {
        int common = gcd (Math.abs(numerator), denominator);
       try {
           _numerator = numerator / common;
           _denominator = denominator / common;
       }catch (ArithmeticException Ae){
           System.out.println("common denominator is zero");
       }

        return  new Rational(_numerator, _denominator);
    }

    private int gcd (int num1, int num2)
    {
//        if (num1 < 0) num1 = -num1;
//        if (num2 < 0) num2 = -num2;
        if (num2 == 0) return num1;
        else return gcd(num2, num1 % num2);
    }
}
