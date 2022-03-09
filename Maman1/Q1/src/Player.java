/*
Representation of player that playing the game
 */

public class Player {
    private String name;
    private Hand hand;

    Player(String name){
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }
    public void setHand(Hand otherHand){
        hand =  otherHand;
    }

    public String getName(){
        return  name;
    }

    public  void setName(String otherName){
        name = otherName;
    }
}
