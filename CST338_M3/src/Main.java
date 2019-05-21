/**
 * Main class for testing the card game classes Deck, Hand, and Card
 * 
 * @author Jasper Kolp
 * @author Kate Adler
 * @author Michael Lee
 * @author Michael Garber
 */

 import java.util.Scanner;

class Main
{
   public static void main(String[] args)
   {
     /*
      //Card class testing
      Card card1 = new Card();
      Card card2 = new Card('d', Card.Suit.CLUBS);	// Error flag on, no 'd' value
      Card card3 = new Card(card1);

      System.out.println(card1);
      System.out.println(card2);
      System.out.println(card3);

      if (card1.equals(card3))
         System.out.println("equals function works");

      card1.set('z', Card.Suit.DIAMONDS);	// Error flag for 'z' is invalid
      card2.set('K', Card.Suit.SPADES);

      System.out.println(card1);
      System.out.println(card2);
      System.out.println(card3);	// "A of SPADES" for card3 = new Card(card1) before

      System.out.println(card2.getValue());
      System.out.println(card2.getSuit());
      System.out.println(card2.getErrorFlag());

      System.out.println(card1.getValue());
      System.out.println(card1.getSuit());
      System.out.println(card1.getErrorFlag());
      
      //Hand class testing
      // Testing for Hand Class
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
      /*Declare a deck containing two packs of cards. Do not shuffle.  Deal all the cards in a loop until the deck is empty (dealt directly to the display/screen, not to any Hand objects just yet).  Display each card as it comes off the deck.  Next, reset the deck by initializing it again (to the same two packs).  Shuffle the deck this time, and re-deal to the screen in a loop again. Notice that the cards are now coming off in a random order.

        Repeat this double deal, unshuffled, then shuffled, but this time using a single pack deck.*/
      
      // Deck Testing
      /*
      Deck deck = new Deck(2);
      Card tempCard2 = new Card();
      boolean test = false;
      int counter =0;
      while (!test)
      {
        tempCard2 = deck.dealCard();
        //System.out.printf("%nTOP CARD: %s%n",deck.getTopCard().toString());
        //System.out.println(tempCard2.getValue());
        if (tempCard2.getErrorFlag())
        {
            break;
        }
        else
        {
            counter++;
            System.out.printf("%s / ",tempCard2.toString());
        }
      }
      //number of cards in the deck
      System.out.printf("%nTotal Count : %d %n",counter);
      
      */

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
        System.out.println("Choose the number of player from 1 to 10.");
        
        if (input.hasNextInt())
        {
        	numPlayers = input.nextInt();
        	if (numPlayers > 0 && numPlayers <= 10 )	// Success case
        	{	
        		validation = true;
        		input.close();
        	}else // When input is not a number between 1 to 10
        	{
        		System.out.println("The number you've chosen is not bewteen 1 to 10.");
        	}
        }else	// When input is not an integer
        {
          System.out.println("You did not enter a number.");
          input.next();
        } 
      }

      System.out.printf("Number of players : %d %n", numPlayers);	// Number of players

      Deck newDeck = new Deck();
      Hand[] hands = new Hand[numPlayers];
      int counting = 0;
      /*
      for (int i = 0 ; i < numPlayers; i++)
      {
          for(int k = 0; k < newDeck.CARDS_IN_PACK - 1; k++)
          {
            hands[i] = new Hand();
            if (hands[i].takeCard(newDeck.dealCard()))
            {
              System.out.println("Card has been distributed.");
              counting++;
            }else {
              System.out.println("Failed to distributed.");
            }

            System.out.println("Top Card: " +  newDeck.getTopCard().toString());
          }
      }
      */
      
      /*
      while(!newDeck.getTopCard().getErrorFlag())
      {
    	  for (int i = 0; i < numPlayers; i++)
    	  {
    		  hands[i] = new Hand();
    		  if (hands[i].takeCard(newDeck.dealCard()))
              {
                System.out.println("Card has been distributed.");
                counting++;
              }
    	  }
      }
      */
      
      for (int x = 0; x < numPlayers; x++)
      {
    	  hands[x] = new Hand();
      }
       
      while(!newDeck.getTopCard().getErrorFlag())
      {
        for (int i = 0 ; i < numPlayers; i++)
        {
          System.out.println("Top Card: " +  newDeck.getTopCard().toString());
          if(hands[i].takeCard(newDeck.dealCard()))
          {
            System.out.println("Card has been distributed.");
            System.out.printf("Player # %d ", i);
            counting++;
          }
          else 
          {
            System.out.println("Failed to distributed.");
            break;
          }
        }
      }
      
      System.out.printf("Counter : %d %n", counting);
      System.out.println("\n\nHANDS\n");
      
      for(int j = 0; j < numPlayers; j++)
      {
    	  //for(int x = 0; x < hands[j].getNumCards(); x++)
    	  //{
    	  	System.out.println("Print Hands : ");
    		System.out.print(" " + hands[j].toString() + " " + "\n\n");
    	  //}
      }
      
      
      System.out.println("*********************************");
      newDeck.init(1);
      newDeck.shuffle();
      
      for (int i = 0; i < numPlayers; i++)
      {
    	  hands[i].resetHand();
      }
      
      while(!newDeck.getTopCard().getErrorFlag())
      {
        for (int i = 0 ; i < numPlayers; i++)
        {
          System.out.println("Top Card: " +  newDeck.getTopCard().toString());
          if(hands[i].takeCard(newDeck.dealCard()))
          {
            //System.out.println("Card has been distributed.");
            //System.out.printf("Player # %d ", i);
            counting++;
          }
          else 
          {
            System.out.println("Failed to distributed.");
            break;
          }
        }
      }
      
      
      for(int j = 0; j < numPlayers; j++)
      {
    	  	System.out.println("Print Hands : ");
    		System.out.print(" " + hands[j].toString() + " " + "\n\n");
      }
      
   }
}

