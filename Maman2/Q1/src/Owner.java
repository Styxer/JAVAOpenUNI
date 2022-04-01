import java.util.Objects;

/*Represents an owner of some animal*/
public class Owner implements Cloneable {
    private String _name;
    private String _phone;

    public  Owner(String name, String phone) {
        _name = name;
        _phone = phone;
    }


    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getPhone() {
        return _phone;
    }

    public void setPhone(String phone) {
        _phone = phone;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "_name='" + _name + '\'' +
                ", _phone='" + _phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(_name, owner._name) && Objects.equals(_phone, owner._phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_name, _phone);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
