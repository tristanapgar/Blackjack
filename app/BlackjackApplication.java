package app;

import java.awt.event.*;
import gui.*;

/**
 * Main app for Blackjack.
 *
 * @author Tristan Apgar
 * @version Fall 2025
 */
public class BlackjackApplication extends JApplication implements ActionListener
{
  public static final int WIDTH = 1000;
  public static final int HEIGHT = 700;
  private StartScreen startScreen;
  private MainScreen mainScreen;

  /**
   * Default constructor for BlackjackApplication.
   */
  public BlackjackApplication(final String[] args)
  {
    super(WIDTH, HEIGHT);
  }

  @Override
  public void init()
  {
    // build both screens up front
    startScreen = new StartScreen(17, this);
    mainScreen = new MainScreen(17, this);

    // build start screen first
    startScreen.getView().setBounds(0, 0, WIDTH, HEIGHT);
    getContentPane().add(startScreen.getView());
    startScreen.start();
    getContentPane().revalidate();
    getContentPane().repaint();
  }

  /**
   * Switch from StartScreen to MainScreen.
   *
   */
  public void goToGame()
  {
    getContentPane().remove(startScreen.getView());
    mainScreen.getView().setBounds(0, 0, WIDTH, HEIGHT);
    getContentPane().add(mainScreen.getView());
    mainScreen.start();
    getContentPane().revalidate();
    getContentPane().repaint();
  }

  /**
   * Switch from MainScreen to StartScreen.
   */
  public void goToStart()
  {
    getContentPane().remove(mainScreen.getView());
    startScreen = new StartScreen(17, this); // rebuild
    startScreen.getView().setBounds(0, 0, WIDTH, HEIGHT);
    getContentPane().add(startScreen.getView());
    startScreen.start();
    getContentPane().revalidate();
    getContentPane().repaint();
  }

  @Override
  public void actionPerformed(final ActionEvent e)
  {
    // no current use but its inherited
  }

  /**
   * Launch the application.
   *
   * @param args
   *          default args
   */
  public static void main(final String[] args)
  {
    JApplication app = new BlackjackApplication(args);
    JApplication.invokeInEventDispatchThread(app);
  }

}
