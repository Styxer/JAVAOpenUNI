/*

Representation of a deck of cards. 52 cards in a total, made of 4 suits of card

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Deck {
    private  List<Card> cards = new ArrayList<>();
    private  int DECK_SIZE = 52;

    Deck(){
        createDeck();
    }

    public  void createDeck(){
        for(Suit suit : Suit.values()){
            for(Rank rank : Rank.values()){
                cards.add(new Card(rank, suit));
            }
        }
    }

    //number of cards left in the deck
    public  int getDeckSize(){
        return DECK_SIZE;
    }

    // List of  Cards
    public List<Card> getCards(){
        return  cards;
    }

    //number of cards left in the deck
    public int getCardsCount(){
        return  cards.size();
    }

    //Deals a card from the top of the deck, removing it from the deck.
    public Card dealCard(){
        return cards.remove(cards.size() - 1);
    }

    //shuffle the location of cards to be  random
    public  void shuffleDeck(){
        Collections.shuffle(cards);
    }

    //Adds a card to  the deck.
    public void addCard(Card card){
        cards.add(card);
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
