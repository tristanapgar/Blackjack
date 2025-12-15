package user;

/**
 * Simple dealer class.
 */
public class Dealer
{
  private int handValue; // amount the hand is worth

  /**
   * Default constructor for Dealer.
   */
  public Dealer()
  {
    handValue = 0;
  }

  /**
   * Search for how much the player puts into the pot.
   *
   * @return the value in the pot
   */
  public int getHandValue()
  {
    return handValue;
  }

  /**
   * Set the amount of money in the pot.
   */
  public void setHandValue(final int value)
  {
    handValue = value;
  }

}
