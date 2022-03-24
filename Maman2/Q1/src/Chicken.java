import java.awt.*;
import java.util.Objects;

public class Chicken extends  Bird{

    private Owner _owner;

    protected Chicken(Owner owner,  int flyDistance, String name, int age, Color color) {
        super(flyDistance, name, age, color);
        _owner = owner;
    }

    @Override
    public String toString() {
        return "Chicken{" +
                "_name='" + _name + '\'' +
                ", _age=" + _age +
                ", _color=" + _color +
                ", _flyDistance=" + _flyDistance +
                ", _owner=" + _owner +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Chicken chicken = (Chicken) o;
        return _owner.equals(chicken._owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), _owner);
    }

    public Owner getOwner() {
        return _owner;
    }

    public void setOwner(Owner owner) {
        _owner = owner;
    }

    @Override
    public void sleep() {
        System.out.println("Chicken sleep");
    }

    @Override
    public void eat() {
        System.out.println("Chicken eat");
    }

    @Override
    protected void fly() {
        System.out.println("Chicken fly");
    }
}
