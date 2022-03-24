import java.awt.*;
import java.util.Objects;

public abstract class Reptile extends Animal{

    protected  int _leapDistance;

    protected Reptile(int leapDistance, String name, int age, Color color) {
        super(name, age, color);
        _leapDistance = leapDistance;
    }

    public int getLeapDistance() {
        return _leapDistance;
    }
    public void setLeapDistance(int leapDistance) {
        _leapDistance = leapDistance;
    }

    @Override
    public String toString() {
        return "Reptile{" +
                "_name='" + _name + '\'' +
                ", _age=" + _age +
                ", _color=" + _color +
                ", _leapDistance=" + _leapDistance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Reptile reptile = (Reptile) o;
        return _leapDistance == reptile._leapDistance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), _leapDistance);
    }

    protected abstract void leap();
}
