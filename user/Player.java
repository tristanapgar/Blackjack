package user;

/**
 * Simple player class.
 * 
 * @author Tristan Apgar
 * @version Fall 2025
 */
public class Player
{
  private int money; // amount in chips
  private int handValue; // bet amount for current hand

  /**
   * Default constructor for Player.
   * 
   * @param money
   *          how much money the player has
   */
  public Player(final int money)
  {
    this.money = money;
    this.handValue = 0;
  }

  /**
   * Search for the amount of money player has.
   * 
   * @return money how much money the player has
   */
  public int getMoney()
  {
    return money;
  }

  /**
   * Change the amount of money player has.
   * 
   * @param amount
   *          goes up on win, stays same on tie, down on loss
   */
  public void adjustMoney(final int amount)
  {
    money += amount;
  }

  /**
   * Search for the amount the player bets on the current hand.
   * 
   * @return the amount the player puts in the pot
   */
  public int getHandValue()
  {
    return handValue;
  }

  /**
   * Set the amount of money the player puts in the pot.
   * 
   * @param value
   *          the value in the pot
   */
  public void setHandValue(final int value)
  {
    handValue = value;
  }

}
