package gui;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import visual.statik.SimpleContent;

/**
 * Background class to render the background on screens.
 *
 * @author Tristan Apgar
 * @version Fall 2025
 */
public class Background implements SimpleContent
{
  private Color color;

  /**
   * Default constructor for Background.
   *
   * @param color
   *          the bg color
   */
  public Background(final Color color)
  {
    this.color = color;
  }

  @Override
  public void render(final Graphics g)
  {
    Graphics2D g2 = (Graphics2D) g;
    Rectangle2D.Double rect = new Rectangle2D.Double(0, 0, 1015, 715);
    g2.setColor(color);
    g2.fill(rect);
  }

}
