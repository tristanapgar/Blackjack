package music;

import io.ResourceFinder;
import resources.Marker;

/**
 * Simple AudioManager class to manage audio files for Blackjack game.
 *
 * @author Tristan Apgar
 * @version Fall 2025
 */
public class AudioManager
{
  private MusicPlayer introMusic;
  private MusicPlayer mainMusic;
  private MusicPlayer shuffleMusic;
  private MusicPlayer playerWinMusic;
  private MusicPlayer dealerWinMusic;
  private ResourceFinder finder;

  /**
   * Default constructor for AudioManager.
   */
  public AudioManager()
  {
    finder = ResourceFinder.createInstance(new Marker());
    try
    {
      introMusic = new MusicPlayer(finder, "blackjack_intro.wav");
      mainMusic = new MusicPlayer(finder, "blackjack_main.wav");
      shuffleMusic = new MusicPlayer(finder, "card_shuffle.wav");
      playerWinMusic = new MusicPlayer(finder, "player.wav");
      dealerWinMusic = new MusicPlayer(finder, "dealer.wav");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  /**
   * Play the startscreen music file.
   */
  public void playIntro()
  {
    stopAll();
    if (introMusic != null)
    {
      introMusic.loop();
    }
  }

  /**
   * Play the mainscreen music file.
   */
  public void playMain()
  {
    stopAll();
    if (mainMusic != null)
    {
      mainMusic.loop();
    }
  }

  /**
   * Play the shufflecards file at the start of each hand.
   */
  public void playShuffle()
  {
    if (shuffleMusic != null)
    {
      shuffleMusic.play();
    }
  }

  /**
   * Play the player win music when player wins hand.
   */
  public void playPlayerWin()
  {
    if (playerWinMusic != null)
    {
      playerWinMusic.play();
    }
  }

  /**
   * Play the dealer win music when dealer wins hand.
   */
  public void playDealerWin()
  {
    if (dealerWinMusic != null)
    {
      dealerWinMusic.play();
    }
  }

  /**
   * Stop playback when needed.
   */
  public void stopAll()
  {
    if (introMusic != null)
    {
      introMusic.stop();
    }
    if (mainMusic != null)
    {
      mainMusic.stop();
    }
    if (shuffleMusic != null)
    {
      shuffleMusic.stop();
    }
    if (playerWinMusic != null)
    {
      playerWinMusic.stop();
    }
    if (dealerWinMusic != null)
    {
      dealerWinMusic.stop();
    }
  }

}
