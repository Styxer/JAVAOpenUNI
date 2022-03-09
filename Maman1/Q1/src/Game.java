/*

Representation of game which is played
 */

import java.util.List;

public class Game {

    private Deck deck;

    private Player human;
    private Player cpu;

    private int maxRounds = 50;
    private final int TIE_CARD_AMOUNT_TO_TAKE = 3;


    //start the game
    public   void startGame(){

        String name = PrintHelper.askFromPlayerName();
        human = new Player(name);
        cpu = new Player("CPU-BOT");

        PrintHelper.printGameStartMsg(maxRounds,human,cpu);

        deck = new Deck();
        deck.shuffleDeck();

        //create and set player and cpu
        human.setHand(new Hand());
        cpu.setHand(new Hand());

        //deal Cards to both player and cpu
        dealCards(human.getHand());
        dealCards(cpu.getHand());

        Player winner = null;
        while ((playWar(human, cpu,null))){
            maxRounds --;
            // check hands for winner

            if(human.getHand().handSize() == 0){
                winner = cpu;
                break;
            }
            else if(cpu.getHand().handSize() == 0){
                winner = human;
                break;
            }

            if(maxRounds < 0)
                break;

            if(winner != null){
                //someone won
            }else if(human.getHand().handSize() > cpu.getHand().handSize()){
                winner = human;
            }else if(cpu.getHand().handSize() > human.getHand().handSize()) {
                winner = cpu;
            }else{
                //draw
                PrintHelper.printGameDraw();
                return;
            }
            PrintHelper.printGameWinner(winner);





        }

    }

    /*
    This simulates the "war" round between player1 and player 2
    if the two players have the same card value,the "war" will happen, three cards from each player are placed
    in the prize pool, and the "war" continued  recursively
     */
    public  boolean playWar(Player firstPlayer, Player secondPlayer, Hand hand){

        //both players show their top card from their deck, each player draws from the top of the deck,

        Card firstPlayerFaceUp = firstPlayer.getHand().removeCardFromTop();
        if(firstPlayerFaceUp == null)
            return  false;

        Card secondPlayerFaceUp = secondPlayer.getHand().removeCardFromTop();
        if(secondPlayerFaceUp == null)
            return  false;


        if(hand == null)
            hand = new Hand();

        hand.addCardToTop(firstPlayerFaceUp);
        hand.addCardToTop(secondPlayerFaceUp);

        int result = firstPlayerFaceUp.compareTo(secondPlayerFaceUp);
        switch (result){
            case 0 :
                PrintHelper.printWarStarted();
                //it's a tie, the "war" is starting, each player add 3 cards to the "prize" hand
                List<Card> firstPlayerHand  = firstPlayer.getHand().takeCards(TIE_CARD_AMOUNT_TO_TAKE);
                if(firstPlayerHand == null){
                    return  false;
                }
                hand.addCardsToTop(firstPlayerHand);

                List<Card> secondPlayerHand  = secondPlayer.getHand().takeCards(TIE_CARD_AMOUNT_TO_TAKE);
                if(secondPlayerHand == null){
                    return  false;
                }
                hand.addCardsToTop(secondPlayerHand);
                return  playWar(firstPlayer, secondPlayer, hand);
            case 1:
                //first player won this round
                firstPlayer.getHand().mergeHands(hand);
                PrintHelper.printRoundWinner(firstPlayer, firstPlayerFaceUp, secondPlayer, secondPlayerFaceUp, firstPlayer.getName());
                break;
            case -1:
                //second player won this round
                secondPlayer.getHand().mergeHands(hand);
                PrintHelper.printRoundWinner(firstPlayer, firstPlayerFaceUp, secondPlayer, secondPlayerFaceUp, secondPlayer.getName());
                break;


        }

        return  true;
    }

    // Deal 26 cards to each player hand
    private void dealCards(Hand hand){
        for(int i = 0 ; i< deck.getDeckSize() / 2; i++){
            hand.addCardToTop(deck.dealCard());
        }
    }
}
