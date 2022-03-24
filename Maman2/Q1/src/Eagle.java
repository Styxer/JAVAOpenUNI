import java.awt.*;
import java.util.Objects;

public class Eagle extends  Bird{

    private Owner _owner;

    public Eagle(int flyDistance, String name, int age, Color color, Owner _owner) {
        super(flyDistance, name, age, color);
        this._owner = _owner;
    }

    @Override
    public String toString() {
        return "Eagle{" +
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
        Eagle eagle = (Eagle) o;
        return _owner.equals(eagle._owner);
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
        System.out.println("Eagle sleep");
    }

    @Override
    public void eat() {
        System.out.println("Eagle eat");
    }

    @Override
    protected void fly() {
        System.out.println("Eagle fly");
    }
}
