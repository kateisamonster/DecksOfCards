/**
 * Deck class to keep track of the whole deck of cards for a card game
 * interacts with Hand and Card classes
 * 
 * @author Jasper Klop
 * @author Kate Adler
 * @author Michael Lee
 * @author Michael Garber
 */

import java.util.Random;

class Deck
{
   public static final int CARDS_IN_PACK = 52;
   public final int MAX_CARDS = CARDS_IN_PACK*6; //essentially a max of 6 card packs
   
   /** contains one full pack of cards, to be copied as necessary into the deck */
   private static Card[] masterPack = new Card[CARDS_IN_PACK];
   
   private Card[] cards = new Card[MAX_CARDS];
   private int topCard;
   
   /**Constructor with specified number of packs
    * @param numpacks   number of card packs in deck
   */
   Deck(int numPacks)
   {
      if (masterPack[0]!=null && masterPack[0].equals(new Card('2', Card.Suit.SPADES)))
         allocateMasterPack();
         
      topCard = (CARDS_IN_PACK * numPacks)-1;
      
      for (int i = 0; i < numPacks; i++)
         for (int j = 0; j < CARDS_IN_PACK; i++)
            cards[(i*CARDS_IN_PACK)+j] = new Card(masterPack[j]);
      
   }

   /** Default Constructor (calls the constructor with numPacks=1 parameter) */
   Deck()
   {
      this(1);
   }
   
   /** Creates the master pack where all the card values will come from */
   private void allocateMasterPack()
   {
      char[] values = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
      int arrayIndex = 0;
      for(char v:values)
         for(int s = 0; s < 4; s++)
            Deck.masterPack[arrayIndex++] = new Card(v, getSuit(s));
   }
   
   /** Switch for getting a suit from an integer
    * @param num  int from 0-3 corresponding to card suits
    * @return     the suit corresponding to the number input
   */
   private Card.Suit getSuit(int num)
   {
      Card.Suit suit  = Card.Suit.SPADES;
      
      switch(num) { 
         case 0:
            suit = Card.Suit.SPADES;
            break;
         case 1:
            suit = Card.Suit.HEARTS;
            break;
         case 2:
            suit = Card.Suit.CLUBS;
            break;
         case 3:
            suit = Card.Suit.DIAMONDS;
            break;
         default:
            //Included for degugging
            System.out.println("Encountered error");
      }

      return suit;
   }

   /** repopulate the deck
    * @param numPacks   number of card packs in deck
    */  
   public void init(int numPacks)
   {
      this.topCard = ((CARDS_IN_PACK * numPacks)-1);
      // Number of packs
      for (int i = 0; i < numPacks; i++)
         for (int j = 0; j < CARDS_IN_PACK; j++)  
            this.cards[(i*CARDS_IN_PACK)+j] = new Card(masterPack[j]);
   }
   
   /** 
    * @return reference to the top card (at cards[topCard])
    */
   public Card getTopCard()
   {
      if(topCard<0)
         return new Card('z', Card.Suit.SPADES);
      return inspectCard(topCard);
   }
   
   /** returns and removes the top card from the deck (uses getTopCard())
    * @return reference to the top card (or an illegal card if deck is empty)
    */
   public Card dealCard()
   {
      Card tempCard = getTopCard();
      topCard--;
      return tempCard;
   }

   /** peeks at a card in the deck without removing it
    * @param k index of the desired card to inspect
    * @return  reference to the card at index k
    */
   public Card inspectCard(int k)
   {
      //Return the card in position k
      if(k <= this.topCard)
         return this.cards[k];
      //Return an illegal card
      else
         return new Card('z',Card.Suit.SPADES);
   }

   /** shuffles cards in deck */
   public void shuffle()
   {
      Random rng = new Random();
      int index; 
      Card temp;
      for(int i=topCard; i>0; i--){
         index = rng.nextInt(i);
         //Swap cards[index] with cards[i]
         temp = this.cards[index];
         this.cards[index] = this.cards[i];
         this.cards[i] = temp;
      }
   }
}


