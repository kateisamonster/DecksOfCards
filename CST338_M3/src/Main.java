class Main
{
   public static void main(String[] args)
   {
      //Card class testing
      Card card1 = new Card();
      Card card2 = new Card('d', Card.Suit.CLUBS);
      Card card3 = new Card(card1);

      System.out.println(card1);
      System.out.println(card2);
      System.out.println(card3);

      if (card1.equals(card3))
         System.out.println("equals function works");

      card1.set('z', Card.Suit.DIAMONDS);
      card2.set('K', Card.Suit.SPADES);

      System.out.println(card1);
      System.out.println(card2);
      System.out.println(card3);

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
   }
}

