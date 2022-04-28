import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Person implements  Comparable<Person>{

    private int _id;
    private String _lastName;
    private String _firstName;
    private LocalDate _DOB;


    public Person(int id, String lastName, String firstName, LocalDate DOB) {
        _id = id;
        _lastName = lastName;
        _firstName = firstName;
        _DOB = DOB;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    public LocalDate getDOB() {
        return _DOB;
    }

    public void setDOB(LocalDate DOB) {
        _DOB = DOB;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(_id, other._id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(_id, person._id);

    }
    @Override
    public int hashCode() {
        return Objects.hash(_id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "_id=" + _id +
                ", _lastName='" + _lastName + '\'' +
                ", _firstName='" + _firstName + '\'' +
                ", _DOB=" + _DOB +
                '}';
    }
}
