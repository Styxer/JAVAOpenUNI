import java.awt.*;
import java.util.Objects;


public class TRex extends Reptile{

    private Owner _owner;

    /*Represents a TRex*/
    protected TRex(Owner owner, int leapDistance, String name, int age, Color color) {
        super(leapDistance, name, age, color);
        _owner = owner;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        TRex clone =  (TRex)super.clone();
        clone._owner = (Owner)this._owner.clone();
        return  clone;
    }

    public Owner getOwner() {
        return _owner;
    }

    public void setOwner(Owner owner) {
        _owner = owner;
    }

    @Override
    void sleep() {
        System.out.println("Trex sleep");
    }

    @Override
    void eat() {
        System.out.println("eat sleep");
    }

    @Override
    protected void leap() {
        System.out.println("Trex leap");
    }

    @Override
    public String toString() {
        return "TRex{" +
                "_name='" + _name + '\'' +
                ", _age=" + _age +
                ", _color=" + _color +
                ", _leapDistance=" + _leapDistance +
                ", _owner=" + _owner +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TRex tRex = (TRex) o;
        return Objects.equals(_owner, tRex._owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), _owner);
    }
}
