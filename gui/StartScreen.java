package gui;

import java.awt.Color;
import javax.swing.SwingUtilities;
import app.BlackjackApplication;
import music.MusicPlayer;
import io.ResourceFinder;
import resources.Marker;
import visual.dynamic.described.Stage;

/**
 * Simple Blackjack start screen.
 * 
 * @author Tristan Apgar
 * @version Fall 2025
 */
public class StartScreen extends Stage
{
  private MusicPlayer introMusic;

  public StartScreen(int timeStep, BlackjackApplication app)
  {
    super(timeStep);

    // add screen content
    add(new Background(Color.BLACK));
    add(new StartScreenContent());

    // play music
    buildMusic();

    // handle clicks
    getView().addMouseListener(new StartScreenListener(app, introMusic));
    getView().setFocusable(true);
    SwingUtilities.invokeLater(() -> getView().requestFocusInWindow());
  }

  private void buildMusic()
  {
    try
    {
      introMusic = new MusicPlayer(ResourceFinder.createInstance(new Marker()),
          "blackjack_intro.wav");
      introMusic.loop();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  @Override
  public void handleTick(int dt)
  {
    // just repaint the screen
    getView().repaint();
  }

}
