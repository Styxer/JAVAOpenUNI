import javax.swing.*;
import java.util.Objects;
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
        String action = JOptionPane.showInputDialog(null, "בחר פעולה\n" +
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
            System.out.println("פעולה לא חוקית ");
    }


    private static Rational createRational(){

        int numerator,denominator;
        //int numeratorInt, denominatorInt;
        Rational rational = null;

        numerator = getNum("רשום את המונה","שגיאה המונה זה לא מספר");
        denominator = getNum("רשום את המכנה", "שגיאה המכנה זה לא מספר");
        denominator = checkNum(denominator,"<","רשום את המכנה","שגיאה: המכנה חייב להיות גדול מאפס");
        denominator = checkNum(denominator,"==","רשום את המכנה","שגיאה: אסור שהמכנה יהיה אפס");

        rational = new Rational(numerator, denominator);
        JOptionPane.showMessageDialog(null, "המספר  שכתבת  הוא(בצורה מצומצמת) " + rational);
        return  rational;

    }

    private static int checkNum(int num, String check, String okMsg, String errMsg)   {
       while (true){
           if(check.equals("<")){
               if(num < 0){
                   JOptionPane.showMessageDialog(null, errMsg);
                   num = getNum(okMsg, errMsg);
               }

               else {
                   break;
               }

           }
           else if (check.equals("==")){
               if(num == 0){
                   JOptionPane.showMessageDialog(null, errMsg);
                   num = getNum(okMsg, errMsg);
               }
               else{
                   break;
               }
           }

       }
       return  num;
    }

    private static int getNum(String okMsg, String errMsg){
        int num = 0;
        while (true){
            String temp = JOptionPane.showInputDialog(null,okMsg);
            if(isInteger(temp)){
                num = Integer.parseInt(temp);
                break;
            }
            else{
                JOptionPane.showMessageDialog(null, errMsg);
            }
        }
        return  num;
    }

    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }

    private static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }
}
