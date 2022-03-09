/*
Representation of a single playing card
A card consist of a suit and rank value

 */
public class Card  {
    private  Rank rank;
    private  Suit suit;
    private  String card;


    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        this.card = rank + " " + suit.getSymbol();
    }

    //name of a card objects suit
    public  Suit getSuit(){
        return  suit;
    }

    // suit shorten symbol name
    public  String getSuitSymbol(){
        return  suit.getSymbol();
    }

    //name of a card objects rank
    public Rank getRank(){
        return  rank;
    }

    // Shorthand of an objects rank
    public  int getCardValue(){
        return  rank.getRankValue();
    }


    //Shorthand of an objects rank and suit
    public  String getCard(){
        return  card;
    }

   //checks 1 if point value thisCard > otherCard,  -1 if this < otherCard and 0 if cards are equal
    public int compareTo(Card otherCard) {
        return Integer.compare(getCardValue(), otherCard.getCardValue());
    }

    //checks if string value of suit of 2 different cards are the same
    public  boolean isSameSuit(Card otherCard){
        return  suit.equals(otherCard.suit);
    }

    // checks if string value of rank of 2 different cards are the same
    public  boolean isSameRank(Card otherCard){
        return  rank.equals(otherCard.rank);
    }

    @Override
    public  boolean equals(Object obj){
        if(obj == null){
            return  false;
        }
        if(obj.getClass() != Card.class){
            return  false;
        }
        final Card otherCard = (Card)obj;
        return suit == otherCard.suit && rank == otherCard.rank;
    }

    @Override
    public String toString() {
        return rank.getRankName() + " of " + suit.getSuitName();
    }


}
