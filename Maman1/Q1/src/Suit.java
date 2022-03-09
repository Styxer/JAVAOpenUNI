/*

Representation of the four suits in a standard deck of cards
 */

public enum Suit {

    DIAMONDS("Diamond", "D"),
    SPADES("Spades", "S"),
    HEARTS("Hearts","H"),
    CLUBS("Clubs","C");

    private String suitName;
    private String symbol;

    Suit(String suitName, String symbol){
        this.suitName = suitName;
        this.symbol = symbol;
    }

    //full name of suit
    public String getSuitName(){
        return  suitName;
    }

    //shorthand name of suit
    public String getSymbol(){
        return  symbol;
    }

    @Override
    public String toString() {
        return getSymbol();
    }
}
