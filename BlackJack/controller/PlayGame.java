package BlackJack.controller;

import BlackJack.view.*;

import java.util.InputMismatchException;
import java.util.Scanner;

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

		m_view.GetInput();
		Scanner sc = new Scanner(System.in);
		try {

			System.out.println("");

			int choice = sc.nextInt();
			Action input = Action.values()[choice];
			switch (input) {
			case Play:
				m_game.NewGame();
				break;
			case Hit:
				m_game.Hit();
				break;
			case Stand:
				m_game.Stand();
				break;
			case Quit:
				return false;
			}
		} catch (Exception e) {
			System.out.println("Warning: invalid option");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				System.out.println("BOOM it crash");
				e1.printStackTrace();
				System.exit(0);
			}
		}

		return true;
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
			Thread.sleep(a_delay);
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