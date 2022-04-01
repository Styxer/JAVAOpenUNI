import java.awt.*;

/*Represents an agama*/
public class Agama extends Reptile{
    public Agama(int leapDistance, String name, int age, Color color) {
        super(leapDistance, name, age, color);
    }

    @Override
    void sleep() {
        System.out.println("Agama sleep");
    }

    @Override
    void eat() {
        System.out.println("Agama eat");
    }

    @Override
    protected void leap() {
        System.out.println("Agama leap");
    }

    @Override
    public String toString() {
        return "Agama{" +
                "_name='" + _name + '\'' +
                ", _age=" + _age +
                ", _color=" + _color +
                ", _leapDistance=" + _leapDistance +
                '}';
    }
}
