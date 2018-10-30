package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.model.Game;
import BlackJack.model.Observer;

public class PlayGame extends Observer {

	private Game a_game;
	private IView a_view;

	public PlayGame(Game a_game, IView a_view) {
		this.a_game = a_game;
		this.a_view = a_view;
	}

	public boolean Play() {
		a_view.DisplayWelcomeMessage();

		a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
		a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

		if (a_game.IsGameOver()) {
			a_view.DisplayGameOver(a_game.IsDealerWinner());
		}

		int input = a_view.GetInput();

		if (a_view.Play(input)) {
			a_game.NewGame();
		} else if (a_view.Hit(input)) {
			a_game.Hit();
		} else if (a_view.Stand(input)) {
			a_game.Stand();
		} else if (a_view.Quit(input)) {
			return false;	// exit the the loop
		}
		return true; // return true if player didn't press 'q'
	}

	@Override
	public void update() {
		/*
		 * TODO Auto-generated method stub need to improve
		 */

	}
}