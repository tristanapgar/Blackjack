package music;

import javax.sound.sampled.*;
import java.io.*;
import io.ResourceFinder;

/**
 * MusicPlayer class loads a .wav and controls playback!
 *
 * @author Tristan Apgar
 * @version Fall 2025
 */
public class MusicPlayer
{
  private Clip clip;
  private boolean loaded = false;
  private String filename;
  private ResourceFinder finder;

  /**
   * Creates MusicPlayer by loading the audio file (only wavs) referenced by ResourceFinder.
   *
   * @param finder
   *          resource finder used to get IS for file
   * @param filename
   *          resource name/path to audio file
   */
  public MusicPlayer(final ResourceFinder finder, final String filename)
  {
    this.finder = finder;
    this.filename = filename;
    loadClip();
  }

  /**
   * Load the requested track.
   */
  private void loadClip()
  {
    try
    {
      if (clip != null)
      {
        clip.stop();
        clip.close();
      }

      InputStream raw = finder.findInputStream(filename);
      if (raw == null)
      {
        System.err.println("MusicPlayer: file not found -> " + filename);
        loaded = false;
        return;
      }

      AudioInputStream stream = AudioSystem.getAudioInputStream(new BufferedInputStream(raw));
      clip = AudioSystem.getClip();
      clip.open(stream);
      loaded = true;
    }
    catch (Exception e)
    {
      System.err.println("MusicPlayer: failed to load " + filename);
      e.printStackTrace();
      loaded = false;
    }
  }

  /**
   * Start playback for an audio clip.
   */
  public void play()
  {
    if (!loaded || clip == null)
    {
      return;
    }
    clip.stop();
    clip.setFramePosition(0);
    clip.start();
  }

  /**
   * Loop track (play again when it ends).
   */
  public void loop()
  {
    if (!loaded)
    {
      return;
    }
    clip.stop();
    clip.setFramePosition(0);
    clip.loop(Clip.LOOP_CONTINUOUSLY);
  }

  /**
   * Pause playback.
   */
  public void pause()
  {
    if (!loaded)
    {
      return;
    }
    clip.stop();
  }

  /**
   * Stop playback.
   */
  public void stop()
  {
    if (!loaded)
    {
      return;
    }
    clip.stop();
    clip.setFramePosition(0);
  }

  /**
   * Look at clip and check if it is playing.
   *
   * @return boolean true if audio file is playing, false otherwise
   */
  public boolean isPlaying()
  {
    return loaded && clip.isRunning();
  }

}
