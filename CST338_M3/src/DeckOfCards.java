import java.util.Scanner;
import java.util.Random;

/**
 * Main class for testing the card game classes Deck, Hand, and Card
 * 
 * @author Jasper Kolp
 * @author Kate Adler
 * @author Michael Lee
 * @author Michael Garber
 */

public class DeckOfCards  
{
   public static void main(String[] args)
   {
     /*
     //==============================================//
      //Card class testing
      //==============================================//
      Card card1 = new Card();
      Card card2 = new Card('d', Card.Suit.CLUBS);  // Error flag on, no 'd' value
      Card card3 = new Card(card1);

      System.out.println(card1);
      System.out.println(card2);
      System.out.println(card3);

      if (card1.equals(card3))
         System.out.println("equals function works");

      card1.set('z', Card.Suit.DIAMONDS);   // Error flag for 'z' is invalid
      card2.set('K', Card.Suit.SPADES);

      System.out.println(card1);
      System.out.println(card2);
      System.out.println(card3);    // "A of SPADES" for card3 = new Card(card1) before

      System.out.println(card2.getValue());
      System.out.println(card2.getSuit());
      System.out.println(card2.getErrorFlag());

      System.out.println(card1.getValue());
      System.out.println(card1.getSuit());
      System.out.println(card1.getErrorFlag());
      
      //==============================================//
      //Hand Testing
      //==============================================//
      // Create new cards
      Card meow = new Card('9',Card.Suit.SPADES);
      Card meow2 = new Card('J', Card.Suit.DIAMONDS);
      Card meow3 = new Card('A', Card.Suit.HEARTS);
      
      Hand hand = new Hand();
      
      //Add cards into hand until full
      boolean checkFull = true;
      while(checkFull == true)
      {
          checkFull = hand.takeCard(meow);
          if (checkFull == false)
          { 
              
              break;
          }
          checkFull = hand.takeCard(meow2);
          if (checkFull == false)
          { 
              break;
          }
          checkFull = hand.takeCard(meow3);
      }
      System.out.println("Hand full\nAfter deal");
      System.out.printf("Hand = ( %s )%n%n", hand.toString());
      
      // Inspect Cards
      int i ;
      System.out.println("Testing inspectCard()");
      Card testCard = new Card();
      
      //Valid Card
      testCard.set('9', Card.Suit.CLUBS);
      System.out.println(testCard.toString());
      
      //Illegal Card
      testCard.set('z', Card.Suit.CLUBS);
      System.out.println(testCard.toString());
      
      // Display all hands.
      for(i = 0 ; i <= hand.getNumCards()-1; i ++ )
      {
          testCard = hand.inspectCard(i);
          System.out.printf("Playing %s%n", testCard.toString());     
      }
          
      hand.resetHand();
      System.out.println("\nAfter playing all cards");
      System.out.printf("Hand = ( %s )%n%n", hand.toString());

      */
      /*Declare a deck containing two packs of cards. Do not shuffle.  Deal all the cards in a loop until the deck is empty (dealt directly to the display/screen, not to any Hand objects just yet).  
      Display each card as it comes off the deck.  Next, reset the deck by initializing it again (to the same two packs).  Shuffle the deck this time, and re-deal to the screen in a loop again. 
      Notice that the cards are now coming off in a random order.

        Repeat this double deal, unshuffled, then shuffled, but this time using a single pack deck.*/
      
      //==============================================//
      //Deck Testing
      //==============================================//
      System.out.println("***************Deck Testing ******************");
      Deck deck = new Deck(2);

      for(int i = 0; i < 104; i++)
      {
         System.out.println(deck.dealCard());
      }

      System.out.println("\n\nReseting deck\n\n");
      deck.init(2);
      deck.shuffle();

      for(int i = 0; i < 104; i++)
      {
         System.out.println(deck.dealCard());
      }

       
      //number of cards in the deck
      //System.out.printf("%nTotal Count : %d %n",counter);
      
      

    //==============================================//
      // Phase 4 Testing
      //==============================================//
      System.out.println("****************Phase 4****************");
      /* planning part 4
        ask user to enter number of players  (1-10)
      
      */
      Scanner input = new Scanner(System.in);
      boolean validation = false;
      int numPlayers =0;

      //Validation for user input.
      while(validation != true)
      { 
        System.out.print("Choose the number of players from 1 to 10: ");
        
        if (input.hasNextInt())
        {
            numPlayers = input.nextInt();
            if (numPlayers > 0 && numPlayers <= 10 )    // Success case
            {   
                validation = true;
                input.close();
            }else // When input is not a number between 1 to 10
            {
                System.out.println("The number you've chosen is not bewteen 1 to 10.");
            }
        }else   // When input is not an integer
        {
          System.out.println("You did not enter a number.");
          input.next();
        } 
      }

      //System.out.printf("Number of players : %d %n", numPlayers);   // Number of players
      System.out.println("Dealing Cards...\n");
      // Creating new deck
      Deck newDeck = new Deck();
      Hand[] hands = new Hand[numPlayers];
      int counting = 0;
      
      // Creating array of empty Hands
      for (int x = 0; x < numPlayers; x++)
      {
          hands[x] = new Hand();
      }
      //==============================================================//
      //Regular (Non Shuffled) Testing
      //==============================================================//
      
      // Distributing the cards in the deck into numPlayers amount of hands
      while(!newDeck.getTopCard().getErrorFlag())
      {
        for (int s = 0 ; s < numPlayers; s++)
        {
            if( newDeck.getTopCard().getErrorFlag())
            {
          	  break;
            }
            else
            {
                if(hands[s].takeCard(newDeck.dealCard()))
                {
              	
                  //System.out.println("Card has been distributed.");
                  //System.out.printf("Player # %d ", s);
                  counting++;
                }
                else 
                {
                  System.out.println("Failed to distributed.");
                  break;
                }
            }

        }
      }
      
      //System.out.printf("Counter : %d %n", counting); // Counting how many cards have been dealt out. Should be 52
      
      // Printing out all the cards in each hands
      for(int j = 0; j < numPlayers; j++)
      {
         System.out.printf("Hand %d : ",j+1);
         System.out.print(" " + hands[j].toString() + " " + "\n\n");
      }
      //==============================================================//
      // SHUFFLED  Testing
      //==============================================================//
      System.out.println("Shuffling");
      
      System.out.println("*********************************");
      System.out.println("Dealing Cards...\n");
      newDeck.init(1);
      newDeck.shuffle();
      // Reset all the hands
      for (int a = 0; a < numPlayers; a++)
      {
          hands[a].resetHand();
      }
      
      // Distribute all the of the cards
      while(!newDeck.getTopCard().getErrorFlag())
      {
        for (int b = 0 ; b < numPlayers; b++)
        {
          if( newDeck.getTopCard().getErrorFlag())
          {
        	  break;
          }
          else
          {
          //System.out.println("Top Card: " +  newDeck.getTopCard().toString());
          if(hands[b].takeCard(newDeck.dealCard()))
          {
            counting++;
          }
          else 
          {
            System.out.println("Failed to distributed.");
            break;
          }
          }
        }
      }
      //Print all of the card values from each hand.
      for(int j = 0; j < numPlayers; j++)
      {
    	    System.out.printf("Hand %d : ",j+1);
            System.out.print(" " + hands[j].toString() + " " + "\n\n");
      }
   }
}


/**
 * Card class to contain the data for one standard card in a card game
 * interacts with Deck and Hand classes
 * 
 * @author Jasper Kolp
 * @author Kate Adler
 * @author Michael Lee
 * @author Michael Garber
 */

class Card
{
   public enum Suit {SPADES, HEARTS, CLUBS, DIAMONDS}; 
   private char value;
   private Suit suit;
   private boolean errorFlag;
   
   /** Default Constructor 
    * calls other constructor with default (A of SPADES) parameter 
    */
   Card()
   {
      this.value = 'A';
      this.suit = Suit.SPADES;
      this.errorFlag = false;
   }
   
   /** Constructor with specified values 
    * @param newValue   desired value for new Card
    * @param newSuit    desired suit for new Card
    */
   Card(char newValue, Suit newSuit)
   {
      if (isValid(newValue, newSuit))
      {
          this.value = Character.toUpperCase(newValue);
          this.suit = newSuit;
      }
      else
      {
          this.errorFlag = true;
      }
   }
   
   /** Copy Constructor 
    * calls other constructor with the parameters of a card to be copied
    * @param card    card to be copied 
    */
   Card(Card card)
   {
      this(card.value, card.suit); //TODO switch back to below lines if this doesn't work for some reason -ka
      //this.value = card.value;
      //this.suit = card.suit;
      //this.errorFlag = card.errorFlag;
   }
   
   /** checks whether 2 cards are the same
    * 
    * @param otherCard  card to be compared
    * @return           whether this and otherCard have same value and suit 
    */
   public boolean equals(Card otherCard)
   {
      return ((this.value == otherCard.value) && (this.suit ==  otherCard.suit));
   }
   
   /** toString overloader for Card class
    * @return string represention of the card
    *          formatted like "A of spades"
    */
   public String toString()
   {
      String cardString;
      
      if(this.errorFlag)
         cardString = "** illegal **";
      else
         cardString = Character.toString(this.value) + " of " + suit;
      
      return cardString;
   }
   
   /** Sets a Card's value and suit
    * 
    * @param value   desired value
    * @param suit    desired suit
    * @return        whether new values are valid & card successfully changed
    */
   public boolean set( char value, Suit suit)
   {
      value = Character.toUpperCase(value);
      if(isValid(value, suit))
      {
         this.value = value;
         this.suit = suit;
         this.errorFlag = false;
      }
      else 
      {
         this.errorFlag = true;
      }
      
      return !this.errorFlag;
   }
   
   /** Accessor for Card value
    * 
    * @return  value of this card
    */
   public char getValue()
   {
      return this.value;
   }
   
   /** Accessor for Card suit
    * 
    * @return  suit of this card
    */
   public Suit getSuit()
   {
      return this.suit;
   }
   

   /** Checks whether Card is invalid (has an error flag)
    * 
    * @return  error state of this Card
    */
   public boolean getErrorFlag()
   {
      return this.errorFlag;
   }
   
   private boolean isValid(char value, Suit suit)
   {
      return "123456789TJQKA".contains(Character.toString(value)) && suit!=null; 
   }
}


/**
 * Hand class to keep track of a player's hand of cards
 * interacts with Deck and Card classes
 * 
 * @author Jasper Kolp
 * @author Kate Adler
 * @author Michael Lee
 * @author Michael Garber
 */

class Hand {
   private Card[] myCards;
   private int numCards;
   private static final int MAX_CARDS = 52;     // Instruction mentions public int value
   
   /** Default Constructor */
   Hand()
   {
      this.myCards = new Card[MAX_CARDS];
      numCards = 0;
   }
   
   /** Clears the current hand */
   public void resetHand()
   {
       this.numCards = 0;
   }
   
   /** adds copy of a card to the hand 
    * @param card    Card to be added to hand
    * @return        whether a card was added or not
    */
   public  boolean takeCard(Card card)
   {
       Card tempCard = new Card(card);
       //tempCard = card;
       boolean wasTaken = false;
       if (numCards <= MAX_CARDS-1)
       {
           this.myCards[this.numCards] = tempCard;
           numCards++;
           return true;
       }
       return wasTaken;
   }
   
   /** plays and removes the top card in hand 
    * @return  Card at the highest index 
    *          (or invalid Card if empty hand)
    */
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
   
   /** 
    * @return   string representation of all cards in hand
                formatted like "A of spades, 2 of clubs, J of hearts"
    */ 
   public String toString()
   {
       String tempCards = "";
       for(int i = 0; i < numCards; i++)
       {
           tempCards += myCards[i].toString() + ", ";
       }
       return tempCards;
   }
   
   
   /** Accessor for numCards
    * 
    * @return  number of cards in hand
    */
   public int getNumCards()
   {
       return this.numCards;
   }
   
   /** Inspect the card at the hand position.
    * 
    * @param k index of card to inspect in hand
    * @return  card at index k
    *          (or invalid card if k is invalid)
    */
   public Card inspectCard(int k)
   {
      if(k >= this.numCards || k < 0) //invalid k 
         return new Card('z',Card.Suit.SPADES); //invalid card w/ error flag
      else 
         return this.myCards[k];
   }
}

/**
 * Deck class to keep track of the whole deck of cards for a card game
 * interacts with Hand and Card classes
 * 
 * @author Jasper Kolp
 * @author Kate Adler
 * @author Michael Lee
 * @author Michael Garber
 */

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
      if (masterPack[0]==null)
         allocateMasterPack();

      init(numPacks);
      topCard = (CARDS_IN_PACK * numPacks) - 1;
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
      this.topCard = ((CARDS_IN_PACK * numPacks) - 1);

      // Number of packs
      for (int i = 0; i < numPacks; i++)
         for (int j = 0; j < CARDS_IN_PACK; j++)  
            this.cards[(i*CARDS_IN_PACK)+j] = new Card(masterPack[j]);
            //System.out.println( (i * CARDS_IN_PACK) + j);
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

/*************OUTPUT*****************
***************Deck Testing ******************
A of DIAMONDS
A of CLUBS
A of HEARTS
A of SPADES
K of DIAMONDS
K of CLUBS
K of HEARTS
K of SPADES
Q of DIAMONDS
Q of CLUBS
Q of HEARTS
Q of SPADES
J of DIAMONDS
J of CLUBS
J of HEARTS
J of SPADES
T of DIAMONDS
T of CLUBS
T of HEARTS
T of SPADES
9 of DIAMONDS
9 of CLUBS
9 of HEARTS
9 of SPADES
8 of DIAMONDS
8 of CLUBS
8 of HEARTS
8 of SPADES
7 of DIAMONDS
7 of CLUBS
7 of HEARTS
7 of SPADES
6 of DIAMONDS
6 of CLUBS
6 of HEARTS
6 of SPADES
5 of DIAMONDS
5 of CLUBS
5 of HEARTS
5 of SPADES
4 of DIAMONDS
4 of CLUBS
4 of HEARTS
4 of SPADES
3 of DIAMONDS
3 of CLUBS
3 of HEARTS
3 of SPADES
2 of DIAMONDS
2 of CLUBS
2 of HEARTS
2 of SPADES
A of DIAMONDS
A of CLUBS
A of HEARTS
A of SPADES
K of DIAMONDS
K of CLUBS
K of HEARTS
K of SPADES
Q of DIAMONDS
Q of CLUBS
Q of HEARTS
Q of SPADES
J of DIAMONDS
J of CLUBS
J of HEARTS
J of SPADES
T of DIAMONDS
T of CLUBS
T of HEARTS
T of SPADES
9 of DIAMONDS
9 of CLUBS
9 of HEARTS
9 of SPADES
8 of DIAMONDS
8 of CLUBS
8 of HEARTS
8 of SPADES
7 of DIAMONDS
7 of CLUBS
7 of HEARTS
7 of SPADES
6 of DIAMONDS
6 of CLUBS
6 of HEARTS
6 of SPADES
5 of DIAMONDS
5 of CLUBS
5 of HEARTS
5 of SPADES
4 of DIAMONDS
4 of CLUBS
4 of HEARTS
4 of SPADES
3 of DIAMONDS
3 of CLUBS
3 of HEARTS
3 of SPADES
2 of DIAMONDS
2 of CLUBS
2 of HEARTS
2 of SPADES


Reseting deck


3 of DIAMONDS
7 of SPADES
2 of DIAMONDS
4 of DIAMONDS
K of SPADES
A of SPADES
9 of SPADES
9 of HEARTS
9 of CLUBS
2 of CLUBS
2 of HEARTS
4 of CLUBS
J of CLUBS
Q of SPADES
6 of DIAMONDS
4 of SPADES
5 of HEARTS
5 of CLUBS
Q of DIAMONDS
K of DIAMONDS
6 of CLUBS
9 of SPADES
8 of SPADES
3 of SPADES
4 of SPADES
2 of SPADES
3 of HEARTS
K of HEARTS
9 of HEARTS
Q of DIAMONDS
3 of DIAMONDS
5 of SPADES
6 of SPADES
6 of SPADES
7 of CLUBS
6 of HEARTS
K of DIAMONDS
4 of HEARTS
A of CLUBS
A of HEARTS
7 of DIAMONDS
T of SPADES
A of CLUBS
3 of SPADES
J of DIAMONDS
2 of HEARTS
8 of HEARTS
Q of CLUBS
7 of HEARTS
T of CLUBS
6 of DIAMONDS
T of DIAMONDS
J of DIAMONDS
A of SPADES
K of CLUBS
7 of HEARTS
4 of CLUBS
5 of DIAMONDS
5 of SPADES
K of HEARTS
5 of CLUBS
A of HEARTS
T of SPADES
3 of HEARTS
9 of DIAMONDS
2 of CLUBS
Q of SPADES
J of SPADES
3 of CLUBS
J of HEARTS
T of HEARTS
6 of CLUBS
7 of CLUBS
5 of HEARTS
8 of CLUBS
K of CLUBS
J of SPADES
9 of CLUBS
Q of HEARTS
6 of HEARTS
4 of HEARTS
8 of DIAMONDS
2 of SPADES
4 of DIAMONDS
8 of SPADES
T of CLUBS
9 of DIAMONDS
7 of DIAMONDS
Q of CLUBS
7 of SPADES
2 of DIAMONDS
8 of HEARTS
A of DIAMONDS
Q of HEARTS
A of DIAMONDS
K of SPADES
8 of DIAMONDS
J of HEARTS
3 of CLUBS
T of DIAMONDS
T of HEARTS
8 of CLUBS
5 of DIAMONDS
J of CLUBS
****************Phase 4****************
Choose the number of players from 1 to 10: 3
Dealing Cards...

Hand 1 :  A of DIAMONDS, A of SPADES, K of HEARTS, Q of CLUBS, J of DIAMONDS, J of SPADES, T of HEARTS, 9 of CLUBS, 8 of DIAMONDS, 8 of SPADES, 7 of HEARTS, 6 of CLUBS, 5 of DIAMONDS, 5 of SPADES, 4 of HEARTS, 3 of CLUBS, 2 of DIAMONDS, 2 of SPADES,  

Hand 2 :  A of CLUBS, K of DIAMONDS, K of SPADES, Q of HEARTS, J of CLUBS, T of DIAMONDS, T of SPADES, 9 of HEARTS, 8 of CLUBS, 7 of DIAMONDS, 7 of SPADES, 6 of HEARTS, 5 of CLUBS, 4 of DIAMONDS, 4 of SPADES, 3 of HEARTS, 2 of CLUBS,  

Hand 3 :  A of HEARTS, K of CLUBS, Q of DIAMONDS, Q of SPADES, J of HEARTS, T of CLUBS, 9 of DIAMONDS, 9 of SPADES, 8 of HEARTS, 7 of CLUBS, 6 of DIAMONDS, 6 of SPADES, 5 of HEARTS, 4 of CLUBS, 3 of DIAMONDS, 3 of SPADES, 2 of HEARTS,  

Shuffling
*********************************
Dealing Cards...

Hand 1 :  2 of SPADES, T of CLUBS, A of CLUBS, 3 of HEARTS, 4 of CLUBS, Q of DIAMONDS, T of SPADES, 9 of SPADES, 7 of DIAMONDS, A of HEARTS, 3 of CLUBS, Q of CLUBS, J of DIAMONDS, 9 of CLUBS, 8 of SPADES, 6 of CLUBS, K of DIAMONDS, 6 of HEARTS,  

Hand 2 :  K of CLUBS, 5 of CLUBS, 9 of DIAMONDS, 8 of HEARTS, J of HEARTS, Q of SPADES, 2 of HEARTS, 8 of DIAMONDS, 5 of SPADES, 4 of HEARTS, J of SPADES, 4 of SPADES, J of CLUBS, 2 of CLUBS, 7 of CLUBS, 6 of SPADES, 2 of DIAMONDS,  

Hand 3 :  K of HEARTS, 3 of SPADES, T of HEARTS, 5 of DIAMONDS, 9 of HEARTS, K of SPADES, 5 of HEARTS, T of DIAMONDS, A of SPADES, 3 of DIAMONDS, 4 of DIAMONDS, Q of HEARTS, 6 of DIAMONDS, A of DIAMONDS, 7 of SPADES, 8 of CLUBS, 7 of HEARTS,  

*/