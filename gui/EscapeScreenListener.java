package gui;

import java.awt.event.*;
import app.BlackjackApplication;

/**
 * EscapeScreenListener class to handle clicking escape to switch to StartScreen.
 *
 * @author Tristan Apgar
 * @version Fall 2025
 */
public class EscapeScreenListener extends KeyAdapter
{
  private final BlackjackApplication app;

  /**
   * Default Constructor for StartScreenListener.
   *
   * @param app
   *          the BlackjackApplication
   */
  public EscapeScreenListener(final BlackjackApplication app)
  {
    this.app = app;
  }

  @Override
  public void keyPressed(final KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
    {
      app.goToStart();
    }
  }

}
