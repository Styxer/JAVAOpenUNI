import java.awt.*;
import java.util.Objects;

public abstract class Bird extends Animal {

    protected  int _flyDistance;
    protected Bird(int flyDistance, String name, int age, Color color) {
        super(name, age, color);
        _flyDistance = flyDistance;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "_name='" + _name + '\'' +
                ", _age=" + _age +
                ", _color=" + _color +
                ", _flyDistance=" + _flyDistance +
                '}';
    }

    protected abstract void fly();




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bird bird = (Bird) o;
        return _flyDistance == bird._flyDistance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), _flyDistance);
    }
}
