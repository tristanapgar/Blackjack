package gui;

import java.awt.*;
import visual.statik.SimpleContent;

/**
 * StartScreenContent class to render text on the StartScreen.
 *
 * @author Tristan Apgar
 * @version Fall 2025
 */
public class StartScreenContent implements SimpleContent
{
  @Override
  public void render(final Graphics g)
  {
    Graphics2D g2 = (Graphics2D) g;
    g2.setColor(Color.WHITE);
    g2.setFont(new Font("Arial", Font.BOLD, 60));
    g2.drawString("BLACKJACK", 300, 250);
    g2.setFont(new Font("Arial", Font.PLAIN, 30));
    g2.drawString("CLICK TO PLAY", 370, 400);
  }

}
