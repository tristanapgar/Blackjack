package gui;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import user.Card;
import visual.statik.SimpleContent;

/**
 * Top-down view of a Blackjack Table.
 * 
 * @author Tristan Apgar
 * @version Fall 2025
 */
public class Table implements SimpleContent
{
  // cards being integrated in
  private java.util.List<Card> playerCards = new ArrayList<>();
  private java.util.List<Card> dealerCards = new ArrayList<>();

  // table colors
  private final Color tableColor = new Color(0, 100, 0); // dark green
  private final Color outlineColor = Color.BLACK;
  private final Color spotColor = Color.GRAY;
  private final Color cardSlotColor = Color.WHITE;

  // table position
  private final int tableX;
  private final int tableY;

  // table dimensions
  private final int tableWidth;
  private final int tableHeight;
  private final int semicircleHeight;

  // player spots
  private final int playerSpotRadius = 15;
  private final int cardSlotWidth = 50;
  private final int cardSlotHeight = 80;

  /**
   * Default Constructor for the Table.
   * 
   * @param stageWidth
   *          table width
   * @param stageHeight
   *          table height
   */
  public Table(final int stageWidth, final int stageHeight)
  {
    this.tableWidth = (int) (stageWidth * 0.75);
    this.tableHeight = (int) (stageHeight * 0.5);
    this.semicircleHeight = tableHeight / 3;

    // center table on screen
    this.tableX = (stageWidth - tableWidth) / 2;
    this.tableY = (stageHeight - tableHeight) / 2;
  }

  @Override
  public void render(Graphics g)
  {
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // draw table ( combination of a circle and rectangle)
    int rectHeight = tableHeight - semicircleHeight;
    Rectangle2D rect = new Rectangle2D.Double(tableX, tableY, tableWidth, rectHeight);
    g2.setColor(tableColor);
    g2.fill(rect);
    g2.setColor(outlineColor);
    g2.draw(rect);
    Arc2D.Double semiCircle = new Arc2D.Double(tableX, tableY + rectHeight - 115, tableWidth,
        semicircleHeight * 2, 0, -180, Arc2D.OPEN);
    g2.setColor(tableColor);
    g2.fill(semiCircle);
    g2.setColor(outlineColor);
    g2.draw(semiCircle);

    // define player spots (5 spots)
    Point[] playerSpots = new Point[5];
    int baseY = tableY + tableHeight - semicircleHeight / 2;
    int offset = 10; // small vertical curve for player positions
    playerSpots[0] = new Point(tableX + tableWidth / 10, baseY - offset); // far-left
    playerSpots[1] = new Point(tableX + 3 * tableWidth / 10, baseY - 2); // middle-left
    playerSpots[2] = new Point(tableX + tableWidth / 2, baseY); // middle (our player )
    playerSpots[3] = new Point(tableX + 7 * tableWidth / 10, baseY - 2); // middle-right
    playerSpots[4] = new Point(tableX + 9 * tableWidth / 10, baseY - offset); // far-right

    // draw the chip spots
    g2.setColor(spotColor);
    for (Point p : playerSpots)
    {
      Ellipse2D.Double spot = new Ellipse2D.Double(p.x - playerSpotRadius,
          p.y - playerSpotRadius - 25, playerSpotRadius * 2, playerSpotRadius * 2);
      g2.fill(spot);
      g2.setColor(outlineColor);
      g2.draw(spot);
      g2.setColor(spotColor);
    }

    // draw the card slots for the players
    g2.setColor(cardSlotColor);
    int slotSpacing = 10;
    for (Point p : playerSpots)
    {
      Rectangle2D.Double cardSlot = new Rectangle2D.Double(p.x - cardSlotWidth / 2,
          p.y - cardSlotHeight - slotSpacing - 50, cardSlotWidth, cardSlotHeight);
      g2.draw(cardSlot);
    }

    // draw dealer card slot
    int dealerSlotWidth = cardSlotWidth;
    int dealerSlotHeight = cardSlotHeight;
    int dealerX = tableX + tableWidth / 2 - dealerSlotWidth / 2;
    int dealerY = tableY + 10; // small margin from top of table
    Rectangle2D.Double dealerSlot = new Rectangle2D.Double(dealerX - 5, dealerY,
        dealerSlotWidth + 10, dealerSlotHeight + 10);
    g2.draw(dealerSlot);

    // animate in player and dealer cards
    double step = 0.1; // adjust speed
    for (Card c : playerCards)
    {
      c.updatePosition(step);
      c.draw((Graphics2D) g);
    }
    for (Card c : dealerCards)
    {
      c.updatePosition(step);
      c.draw((Graphics2D) g);
    }
  }

  /**
   * Deal the cards to the player and dealer.
   */
  public void dealInitialCards()
  {
    // positions for the animation
    double playerX1 = tableX + tableWidth / 2 - 60;
    double playerY1 = -82 + tableY + tableHeight - semicircleHeight / 2 - 60;
    double playerX2 = -14 + tableX + tableWidth / 2 - 10;
    double playerY2 = -84 + tableY + tableHeight - semicircleHeight / 2 - 60;
    double dealerX1 = tableX + tableWidth / 2 - 30;
    double dealerY1 = tableY + 14;
    double dealerX2 = -7 + tableX + tableWidth / 2 + 10;
    double dealerY2 = tableY + 12;

    // add player and dealer cards using the animation
    playerCards.add(new Card("A", "♠", 0, 0, playerX1, playerY1));
    playerCards.add(new Card("10", "♥", 0, 0, playerX2, playerY2));
    dealerCards.add(new Card("K", "♦", 0, 0, dealerX1, dealerY1));
    dealerCards.add(new Card("7", "♣", 0, 0, dealerX2, dealerY2));
  }

}
