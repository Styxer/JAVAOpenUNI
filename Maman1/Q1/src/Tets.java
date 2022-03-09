public class Tets {

    Tets()
    {
        Card testCard = new Card(Rank.EIGHT, Suit.DIAMONDS);
        Card testCardT = new Card(Rank.TEN, Suit.SPADES);
        System.out.println("\n----Card Tests--------");
        System.out.println( testCardT.equals(testCard));
        System.out.println( testCardT.compareTo(testCard));
        System.out.println(testCard);

        System.out.println("\n----Decks Tests--------");
        Deck deck = new Deck();
        System.out.println(deck.getCardsCount());
        System.out.println(deck);
        deck.dealCard();
        deck.dealCard();
        System.out.println(deck.getCardsCount());
        deck.shuffleDeck();
        System.out.println(deck);

        System.out.println("\n----Hand Tests--------");
        Card testCard1 = new Card(Rank.ACE, Suit.SPADES);
        Card testCard2 = new Card(Rank.KING, Suit.HEARTS);
        Card testCard3 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card testCard4 = new Card(Rank.JACK, Suit.CLUBS);
        Hand testHand = new Hand();
        testHand.addCardToTop(testCard1);
        testHand.addCardToTop(testCard2);
        testHand.addCardToTop(testCard3);
        testHand.addCardToTop(testCard4);
        System.out.println(testHand.handSize());
        System.out.println(testHand.removeCardFromTop());
        System.out.println(testHand.handSize());

        System.out.println(testHand.takeCards(2));
    }
}
