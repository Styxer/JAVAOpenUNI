import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        //B
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Chicken(new Owner("farmer","09-7782222"),20,"Josh",3, Color.cyan));
        animalList.add(new Eagle(new Owner("zoo","02-675-0111"), 23, "Izik", 7, Color.black));
        animalList.add(new Salmon( 200, "Shouli", 7, Color.red));
        animalList.add(new Frog( 12, "moshe", 2, Color.green));
        TRex tRex = new TRex(new Owner("Dr. Elen Grant","833-486-3466"), 1, "Haim", 12, Color.gray);
        animalList.add(tRex);
        animalList.add(new Agama( 2, "Yossi", 10, Color.orange));

        for (Animal animal : animalList){
            System.out.println(animal);
            animal.eat();
            animal.sleep();
            if(animal instanceof Fish){
                ( (Fish)animal).swim();
            }
            else  if(animal instanceof Reptile){
                ( (Reptile)animal).leap();
            }
            else  if(animal instanceof Bird){
                ( (Bird)animal).fly();
            }
        }

        //C
        try {
            TRex tRex1 = (TRex) tRex.clone();
            System.out.println("-------------BEFORE ALTERING------------------");
            System.out.println(tRex);
            System.out.println(tRex1);

            System.out.println("-------------AFTER ALTERING------------------");
            tRex1.getOwner().setName("Vadim");
            tRex1.getOwner().setPhone("1234");
            tRex1.setName("Yovav");
            tRex1.setAge(22);
            tRex1.setLeapDistance(10);
            System.out.println(tRex);
            System.out.println(tRex1);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
