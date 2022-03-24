import java.awt.*;

public class Frog extends Reptile{

    protected Frog(int leapDistance, String name, int age, Color color) {
        super(leapDistance, name, age, color);
    }

    @Override
    public void sleep() {
        System.out.println("Frog sleep");
    }

    @Override
    public String toString() {
        return "Frog{" +
                "_name='" + _name + '\'' +
                ", _age=" + _age +
                ", _color=" + _color +
                ", _leapDistance=" + _leapDistance +
                '}';
    }



    @Override
    public void eat() {
        System.out.println("Frog eat");
    }

    @Override
    protected void leap() {
        System.out.println("Frog leap");
    }
}
