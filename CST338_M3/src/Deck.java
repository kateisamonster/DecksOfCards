class Deck
{
   // Max number of card in 6 decks.  6 * 52 = 312
   public final int MAX_CARDS = 312;
   
   private static Card[] masterPack = new Card[52];
   
   private Card[] cards = new Card[MAX_CARDS];
   private int topCard;
   private int cardsInDeck;
   
   Deck(int numPacks)
   {
      if (masterPack[0].equals(new Card('2', Card.Suit.SPADES)))
      {
         allocateMasterPack();
      }
      cardsInDeck = 52 * numPacks;
      
    //TODO  populate cards array with shuffled cards
      
   }
   
   Deck()
   {
      this(1);
   }
   
   private void allocateMasterPack()
   {
      char[] values = 
         {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
      int arrayIndex = 0;
      for(char v:values)
      {
         for(int s = 0; s < 4; s++)
         {
            Card.Suit newSuit = getSuit(s);
            this.cards[arrayIndex] = new Card(v, newSuit);
            arrayIndex++;
         }
      }
   }
   
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
   
   
   
   
   
   
   
   
   
   
   
}