/**
 * Main class for testing the card game classes Deck, Hand, and Card
 * 
 * @author Jasper Klop
 * @author Kate Adler
 * @author Michael Lee
 * @author Michael Garber
 */

class Main
{
   public static void main(String[] args)
   {
      //Card class testing
      Card card1 = new Card();
      Card card2 = new Card('d', Card.Suit.CLUBS); // Error flag on, no 'd' value
      Card card3 = new Card(card1);

      System.out.println(card1);
      System.out.println(card2);
      System.out.println(card3);

      if (card1.equals(card3))
         System.out.println("equals function works");

      card1.set('z', Card.Suit.DIAMONDS); // Error flag for 'z' is invalid
      card2.set('K', Card.Suit.SPADES);

      System.out.println(card1);
      System.out.println(card2);
      System.out.println(card3); // "A of SPADES" for card3 = new Card(card1) before

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


      /*Declare a deck containing two packs of cards. Do not shuffle.  Deal all the cards in a loop until the deck is empty (dealt directly to the display/screen, not to any Hand objects just yet).  Display each card as it comes off the deck.  Next, reset the deck by initializing it again (to the same two packs).  Shuffle the deck this time, and re-deal to the screen in a loop again. Notice that the cards are now coming off in a random order.

        Repeat this double deal, unshuffled, then shuffled, but this time using a single pack deck.*/
      
      // Deck Testing
      Deck deck = new Deck(2);
      Card tempCard2 = new Card();
      boolean test = false;
      while (!test)
      {
        tempCard2 = deck.dealCard();
        if (tempCard2.getErrorFlag())
        {
            break;
        }
        else
        {
            System.out.printf("%s / ",tempCard2.toString());
        }
      }

      /* planning part 4
        ask user to enter number of players  (1-10)

        



        



      */

   }
}

