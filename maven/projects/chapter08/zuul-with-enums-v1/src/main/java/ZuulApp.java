/**
 * The World Of Zuul application. Plays the role of the entire application.
 * The game is initialized and started from this class.
 */
public class ZuulApp {
  /**
   * The main entry point for the application. Creates an instance of the Game and
   * starts the game.
   *
   * @param args The command-line arguments.
   */
  public static void main(String[] args) {
    Game game = new Game();
    game.play();
  }
}
