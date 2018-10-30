package BlackJack;

import BlackJack.model.Game;
import BlackJack.view.*;
import BlackJack.controller.*;

public class Program
{

  public static void main(String[] a_args)
  {
  
    Game game = new Game();
    IView view = new SimpleView(); 
    PlayGame ctrl = new PlayGame(game , view);
    
    while (ctrl.Play());
  }
}