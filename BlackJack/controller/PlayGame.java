package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.model.Game;
import BlackJack.model.IObserver;

public class PlayGame implements IObserver {

	private Game m_game;
	private IView m_view;

	public PlayGame(Game a_game, IView a_view) {
		m_game = a_game;
		m_view = a_view;
		register(this);
	}

	public boolean Play() {
		m_view.DisplayWelcomeMessage();
		m_view.DisplayDealerHand(m_game.GetDealerHand(), m_game.GetDealerScore());
		m_view.DisplayPlayerHand(m_game.GetPlayerHand(), m_game.GetPlayerScore());

		if (m_game.IsGameOver()) {
			m_view.DisplayGameOver(m_game.IsDealerWinner());
		}

		int input = m_view.GetInput();

		if (m_view.Play(input)) {
			m_game.NewGame();
		} else if (m_view.Hit(input)) {
			m_game.Hit();
		} else if (m_view.Stand(input)) {
			m_game.Stand();
		} else if (m_view.Quit(input)) {
			return false; // exit the the loop
		}
		return true; // return true if player didn't press 'q'
	}

	@Override
	public void update(int a_delay) {

		try {
			m_view.DisplayDealingCard();
			Thread.sleep(a_delay);
			m_view.DisplayDealerHand(m_game.GetDealerHand(), m_game.GetDealerScore());
			m_view.DisplayDealingCard();
			Thread.sleep(a_delay);
			m_view.DisplayPlayerHand(m_game.GetPlayerHand(), m_game.GetPlayerScore());
		} catch (InterruptedException e) {
			System.out.println("BOOM it crash");
			e.printStackTrace();
			System.exit(-1);
		}

	}

	public void register(IObserver a_observer) {
		this.m_game.register(a_observer);
	}

}