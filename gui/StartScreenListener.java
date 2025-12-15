package gui;

import java.awt.event.*;
import app.BlackjackApplication;
import music.MusicPlayer;

/**
 * StartScreenListener class to handle clicking start box to switch to MainScreen.
 *
 * @author Tristan Apgar
 * @version Fall 2025
 */
public class StartScreenListener extends MouseAdapter
{
  private final BlackjackApplication app;
  private final MusicPlayer music;

  /**
   * Default Constructor for StartScreenListener.
   *
   * @param app
   *          the BlackjackApplication
   * @param music
   *          the MusicPlayer
   */
  public StartScreenListener(final BlackjackApplication app, final MusicPlayer music)
  {
    this.app = app;
    this.music = music;
  }

  @Override
  public void mouseClicked(final MouseEvent e)
  {
    if (music != null)
    {
      music.stop();
    }
    app.goToGame();
  }

}
