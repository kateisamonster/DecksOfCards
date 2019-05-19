class Card
{
   public enum Suit {SPADES, HEARTS, CLUBS, DIAMONDS}; 
   
   private char value;
   private Suit suit;
   private boolean errorFlag;
   
   Card()
   {
      this.value = 'A';
      this.suit = Suit.SPADES;
      this.errorFlag = false;
   }
   
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
   
   Card(Card card)
   {
      this.value = card.value;
      this.suit = card.suit;
      this.errorFlag = card.errorFlag;
   }
   
   public boolean equals(Card otherCard)
   {
      return ((this.value == otherCard.value) && (this.suit ==  otherCard.suit));
   }
   
   public String toString()
   {
      String cardString;
      
      if(this.errorFlag)
         cardString = "** illegal **";
      else
         cardString = Character.toString(this.value) + " of " + suit;
      
      return cardString;
   }
   
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
   
   
   public char getValue()
   {
      return this.value;
   }
   
   public Suit getSuit()
   {
      return this.suit;
   }
   

   public boolean getErrorFlag()
   {
      return this.errorFlag;
   }
   
   private boolean isValid(char value, Suit suit)
   {
      boolean isValid = false;
      
      if ("123456789TJQKA".contains(Character.toString(value)))
         {
            isValid = true;
         }
      
      return isValid;
   }
}