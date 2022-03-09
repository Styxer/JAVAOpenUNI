import javax.swing.*;

public class PrintHelper {
    public  static  void printGameStartMsg(int maxRounds, Player human, Player cpu)
    {
        JOptionPane.showMessageDialog(null, "The is about to begin\n" +
                "The game is being played between our trusted human and the cpu.\n"+
                "the game will end if one of the players hand is empty or the game reaches " + maxRounds + " rounds\n"+
                "our beloved " + human.getName() + " vs the ugly machine " + cpu.getName());
    }



    public  static  void printRoundWinner(Player player1, Card card1 ,Player player2, Card card2, String winner){
        JOptionPane.showMessageDialog(null,  "player1  " + player1.getName() + " with did " + card1 + " hand size " + player1.getHand().handSize()+
                "\nplayer2  " + player2.getName() + " with did " + card2 + " hand size " + player2.getHand().handSize() +
                "\nthe winner is of the round is" + winner);
    }

    public  static  void printGameWinner(Player player){
        JOptionPane.showMessageDialog(null,"The winner of the game is " + player.getHand());
    }

    public  static  void printGameDraw(){
        JOptionPane.showMessageDialog(null,"Game ended with a draw");
    }

    public  static  void printWarStarted(){
        JOptionPane.showMessageDialog(null,"WAR! there was a tie");
    }

    public static  String askFromPlayerName() {return JOptionPane.showInputDialog("What is your name?");}
}
