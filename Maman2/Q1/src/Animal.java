import java.awt.*;
import java.util.Objects;


/* Represents an animal class*/
public abstract  class   Animal implements  Cloneable {
     String _name;
     int _age ;
     Color _color;

     protected Animal(String name, int age, Color color){
          _name = name;
          _age = age;
          _color = color;
     }


     @Override
     protected Object clone() throws CloneNotSupportedException {
          return super.clone();
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
         if(age <0 ){
              throw new IllegalArgumentException("age cannot be below zero");
         }
          _age = age;
     }

     public Color getColor() {
          return _color;
     }

     public void setColor(Color color) {
          _color = color;
     }

     abstract void sleep();
     abstract void eat();
}
