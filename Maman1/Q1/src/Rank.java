/*
Representation of the 13 possible ranks in a standard dark of card
2 is the lowest value, and Ace is the highest value

 */

public enum Rank{
    TWO("Two",2),
    THREE("Three",3),
    FOUR("Four",4),
    FIVE("Five",5),
    SIX("Six",6),
    SEVEN("Seven",7),
    EIGHT("Eight",8),
    NINE("Nine", 9),
    TEN("Ten", 10),
    JACK("Jack", 11),
    QUEEN("Queen", 12),
    KING("King", 13),
    ACE("Ace",14);


    private String rankName;
    private int rankValue;

    Rank(String rankName, int rankValue) {
        this.rankName = rankName;
        this.rankValue = rankValue;
    }

    // shorthand of rank
    @Override
    public String toString() {
        if(this.rankValue > 10){
            return getRankName().substring(0,1);
        }
        return  String.valueOf(getRankValue());
    }

    //get the value
    public  int getRankValue(){
        return  rankValue;
    }

    //full name  of rank
    public  String getRankName(){
        return  rankName;
    }


}