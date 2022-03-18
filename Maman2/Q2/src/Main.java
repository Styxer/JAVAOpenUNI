import javax.swing.*;
import java.util.Scanner;

import static javax.swing.JOptionPane.showInputDialog;

public class Main {

    public static void main(String[] args) {
//	    Tests tests = new Tests();
//        tests.Run();

        Rational a = createRational();
        if(a != null){
            Rational b = createRational();
            if(b != null){
                chooseOption(a,b);
            }
        }

    }

    private static void chooseOption(Rational a, Rational b){
        String action = JOptionPane.showInputDialog(null, "מה תרצה לעשות כפרע\n" +
                "לחיבור לחץ 1'\n" +
                "לחיסר לחץ '2'\n" +
                "לחילוק לחץ '3'\n" +
                "לכפל לחץ '4'\n" +
                 "לבדיקה האם המספר הראשון גדול מהשני לחץ '5'\n"+
                "לבדיקה האם המספרים שווה לחץ '6'\n");

        if (action.equals("1")) {
           JOptionPane.showMessageDialog(null,a + " + " + b + " = " +  a.plus(b));
        } else if (action.equals("2")) {
            JOptionPane.showMessageDialog(null,a + " - " + b + " = " +  a.minus(b));
        }else if (action.equals("3")) {
            JOptionPane.showMessageDialog(null,a + " / " + b + " = " +  a.divide(b));
        }else if (action.equals("4")) {
            JOptionPane.showMessageDialog(null,a + " * " + b + " = " +  a.multiply(b));
        }else if (action.equals("5")) {
            JOptionPane.showMessageDialog(null,a + " < > = " + b + " =  " +  a.compareTo(b));
        }else if (action.equals("6")) {
            JOptionPane.showMessageDialog(null,a + " =? " + b + " = " +  a.equals(b));
        }else
            System.out.println("פעולה לא חוקית ההורים שלך אחים");
    }


    private static Rational createRational(){

        String numerator,denominator;
        int numeratorInt, denominatorInt;
        Rational rational = null;
        numerator = JOptionPane.showInputDialog(null,"רשום את המונה כפרע");


         numeratorInt = toInt(numerator);

        //TODO : RETRAY
        if(numeratorInt == Integer.MIN_VALUE){
            JOptionPane.showMessageDialog(null, "וולאקס המונה זה לא מספר זה לא מספר + ההורים שלך אחים באנגלית");
        }else{
            denominator = JOptionPane.showInputDialog(null,"רשום את המכנה כפרע");
            denominatorInt = toInt(denominator);
            if(denominatorInt == Integer.MIN_VALUE) {
                JOptionPane.showMessageDialog(null, "וולאקס המכנה זה לא מספר זה לא מספר + ההורים שלך אחים באנגלית");
            }else  if(denominatorInt < 0){
                JOptionPane.showMessageDialog(null, "וולאקס המכנה המכנה חייב להיות גדול מאפס + ההורים שלכם אחים בריבוע");
            }else  if(denominatorInt == 0){
                JOptionPane.showMessageDialog(null, "וולאקס אסור שהמכנה יהיה אפס למה אתה דביל");
            }
            else {
                rational = new Rational(numeratorInt, denominatorInt);
                JOptionPane.showMessageDialog(null, "המספר  שכתבת כפרע הוא(בצורה מצומצמת) " + rational);
            }

        }
        return  rational;
    }


    private static int toInt(String strNum) {
        int result = Integer.MIN_VALUE;
        if (strNum == null) {
            return result;
        }
        try {
            return Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
           return result;
        }
    }
    }
