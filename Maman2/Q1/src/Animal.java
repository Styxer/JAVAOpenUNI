import java.awt.*;
import java.util.Objects;


//TODO CLONE
public abstract  class   Animal {
     String _name;
     int _age ;
     Color _color;

     protected Animal(String name, int age, Color color){
          _name = name;
          _age = age;
          _color = color;
     }



     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Animal animal = (Animal) o;
          return _age == animal._age && _name.equals(animal._name) && _color.equals(animal._color);
     }

     @Override
     public int hashCode() {
          return Objects.hash(_name, _age, _color);
     }

     @Override
     public String toString() {
          return "Animal{" +
                  "_name='" + _name + '\'' +
                  ", _age=" + _age +
                  ", _color=" + _color +
                  '}';
     }

     public String getName() {
          return _name;
     }

     public void setName(String name) {
          _name = name;
     }

     public int getAge() {
          return _age;
     }

     public void setAge(int age) {
          _age = age;
     }

     public Color getColor() {
          return _color;
     }

     public void set_color(Color color) {
          _color = color;
     }

     abstract void sleep();
     abstract void eat();
}
