package user;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Card class that takes cards to dealer and player hands.
 * 
 * @author Tristan Apgar
 * @version Fall 2025
 */
public class Card
{
  private String suit;
  private String value;
  private double x, y; // current position
  private double targetX, targetY; // target position for animation
  private int width = 50;
  private int height = 80;
  private boolean faceUp = true;

  /**
   * Default constructor for Card.
   * 
   * @param value
   *          the card number
   * @param suit
   *          the cards suit
   * @param startX
   *          the start position for lerp
   * @param startY
   *          the start position for lerp
   * @param targetX
   *          the end position for lerp
   * @param targetY
   *          the end position for lerp
   */
  public Card(final String value, final String suit, final double startX, final double startY,
      final double targetX, final double targetY)
  {
    this.value = value;
    this.suit = suit;
    this.x = startX;
    this.y = startY;
    this.targetX = targetX;
    this.targetY = targetY;
  }

  /**
   * Move position during lerp process.
   * 
   * @param step
   *          one step in the lerp
   */
  public void updatePosition(final double step)
  {
    // simple lerp (linear interpolation) for animation
    x += (targetX - x) * step;
    y += (targetY - y) * step;
  }

  /**
   * Draw the cards being animated.
   * 
   * @param g2
   *          the graphics
   */
  public void draw(final Graphics2D g2)
  {
    // card background
    g2.setColor(Color.WHITE);
    g2.fill(new Rectangle2D.Double(x, y, width, height));
    g2.setColor(Color.BLACK);
    g2.draw(new Rectangle2D.Double(x, y, width, height));

    // draw value and suite of card
    if (faceUp)
    {
      g2.setColor(Color.BLACK);
      g2.setFont(new Font("Arial", Font.BOLD, 14));
      g2.drawString(value + suit, (float) x + 5, (float) y + 15);
    }
  }

  /**
   * Search for the x position of the card.
   * 
   * @return the x position
   */
  public double getX()
  {
    return x;
  }

  /**
   * Search for the y position of the card.
   * 
   * @return the y position
   */
  public double getY()
  {
    return y;
  }

}
