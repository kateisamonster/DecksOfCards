class Hand {
   private Card[] myCards;
   private int numCards;
   private static final int MAX_CARDS = 52; 
   
   // Default Constructor.
   Hand()
   {
       this.myCards = new Card[MAX_CARDS];
       numCards = 0;
   }
   
   //Clears the current hand
   public void resetHand()
   {
       /*  If you just set numCards to zero.  The next time you draw a card 
       will start to overwrite what is there.  You dont actually have to 
       empty the array.
       //Iterate through myCards and make each item null
       int i;
       for (i = 0 ; i <= numCards-1 ; i++)
       {
           this.myCards[i] = null;
       }
       */
       this.numCards = 0;
   }
   
   //adds card to the myCard array
   public  boolean takeCard(Card card)
   {
       Card tempCard = new Card();
       tempCard = card; //TODO we need to copy the object, per assignment specs; this just copies the reference to the original card -KA
       boolean wasTaken = false;
       if (numCards <= MAX_CARDS-1)
       {
           this.myCards[this.numCards] = tempCard;
           numCards++;
           return true;
       }
       
       return wasTaken;
       
   }
   
   //returns card at the highest index
   public Card playCard()
   {   
       Card tempCard = new Card('Z', Card.Suit.SPADES);
       if (this.numCards > 0)
       {
           this.numCards--;
           tempCard = this.myCards[this.numCards-1];
       }
       
       return tempCard;
   }
   
   // Returns all cards in the myCards Array
   public String toString()
   {
       String tempCards = "";
       
       for(int i = 0; i < numCards; i++)
           tempCards += myCards[i].toString() + ", ";
       
       return tempCards;
   }
   
   // mutator the numCards
   public boolean setNumCards(int inputNumCards)
   {
       this.numCards = inputNumCards;
       return true;
   }
   
   // Accessor for numCards
   public int getNumCards()
   {
       return this.numCards;
   }
   
   // Inspect the card at the hand position.
   public Card inspectCard(int k)
   {
       Card tempCard = new Card();
       
       // Check to see if k is bad.  If it is, return errorFlag = True
       if(k >= this.numCards || k < 0) // Create a bad card that will have an errorFlag
           tempCard.set('z',Card.Suit.SPADES); 
       else //Else Return card
           tempCard = this.myCards[k];
       
       return tempCard;
   }
}