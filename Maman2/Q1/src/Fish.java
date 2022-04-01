import java.awt.*;
import java.util.Objects;

public abstract class Fish extends Animal {

    protected int _swimDistance;

    /*Represents a fish*/
    protected Fish(int swimDistance, String name, int age, Color color) {
        super(name, age, color);
        _swimDistance = swimDistance;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "_name='" + _name + '\'' +
                ", _age=" + _age +
                ", _color=" + _color +
                ", _swimDistance=" + _swimDistance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Fish fish = (Fish) o;
        return _swimDistance == fish._swimDistance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), _swimDistance);
    }

    public int getSwimDistance() {
        return _swimDistance;
    }

    public void setSwimDistance(int swimDistance) {
        _swimDistance = swimDistance;
    }

    protected abstract void swim();
}
