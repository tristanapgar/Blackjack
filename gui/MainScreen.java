package gui;

import java.awt.*;
import javax.swing.SwingUtilities;
import app.BlackjackApplication;
import resources.Marker;
import io.ResourceFinder;
import music.MusicPlayer;
import visual.dynamic.described.Stage;

/**
 * Blackjack gameplay screen.
 *
 * @author Tristan Apgar
 * @version Fall 2025
 */
public class MainScreen extends Stage
{
  private MusicPlayer mainMusic;

  /**
   * Default constructor for MainScreen.
   *
   * @param timeStep
   *          the timestep
   * @param app
   *          the blackjack application
   */
  public MainScreen(final int timeStep, final BlackjackApplication app)
  {
    super(timeStep);

    // adding visuals to screen
    add(new Background(Color.LIGHT_GRAY));
    Table table = new Table(1000, 700);
    table.dealInitialCards();
    add(table);
    buildMusic();

    // hit escape to return to start screen!
    getView().addKeyListener(new EscapeScreenListener(app));
    getView().setFocusable(true);
    SwingUtilities.invokeLater(() -> getView().requestFocusInWindow());
  }

  /**
   * Construct file to be played in background.
   */
  private void buildMusic()
  {
    try
    {
      mainMusic = new MusicPlayer(ResourceFinder.createInstance(new Marker()),
          "blackjack_main.wav");
      mainMusic.loop();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  @Override
  public void handleTick(int dt)
  {
    super.handleTick(dt);
  }

}
