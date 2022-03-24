import java.awt.*;

public class Salmon extends Fish{


    protected Salmon(int swimDistance, String name, int age, Color color) {
        super(swimDistance, name, age, color);
    }

    @Override
    public void sleep() {
        System.out.println("Salmon sleeping");
    }

    @Override
    public void eat() {
        System.out.println("Salmon eating");
    }

    @Override
    protected void swim() {
        System.out.println("Salmon swimming");
    }



    @Override
    public String toString() {
        return "Salmon{" +
                "_name='" + _name + '\'' +
                ", _age=" + _age +
                ", _color=" + _color +
                ", _swimDistance=" + _swimDistance +
                '}';
    }
}
