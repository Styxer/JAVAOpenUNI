/*

Representation of players card. game starts with half of standard card(52/2=26)
 */

import java.util.ArrayList;
import java.util.List;

public class Hand {
    //players individual cards
    private List<Card> cards;

    Hand(){
        this.cards = new ArrayList<>();
    }

    //merge another hand into this one
    public  void mergeHands(Hand otherHand){
        for(Card card : otherHand.cards){
            addCardToTop(card);
        }
    }

    //Take N cards from player cards
    public  List<Card> takeCards(int cardsAmount){
        if(cardsAmount > handSize())
            return  null;

        List<Card> returnCards = new ArrayList<>();
        for (int i = 0; i < cardsAmount ; i++){
             returnCards.add(cards.remove(handSize() -1));
        }
        return  returnCards;
    }

    //adds a list card  to player hand
    public  void addCardsToTop(List<Card> cards){
        this.cards.addAll(cards);
    }

    //adds a single Card to player hand
    public void addCardToTop(Card card){
        cards.add(card);
    }

    // removes a card from the last index of the array
    public  Card removeCardFromTop(){
        if (handSize() < 1)
            return  null;
        return  cards.remove(handSize() - 1);
    }

    //the number of cards in player hand
    public  int handSize(){
        return cards.size();
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards +
                '}';
    }
}
