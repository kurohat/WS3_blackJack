package BlackJack.view;

import java.util.EnumSet;
import java.util.Scanner;

public class SimpleView implements IView {

	public void DisplayWelcomeMessage() {
		for (int i = 0; i < 50; i++) {
			System.out.print("\n");
		}
		;
		System.out.println("LET PLAY BLACK JACK, GO HARD OR GO HOME YOOOO!!");
	}

	public Action GetInput() {
		for (Action choices : EnumSet.allOf(Action.class)) {
			System.out.print(choices.ordinal() + ": " + choices + " | ");
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("");

		int choice = sc.nextInt();
		return Action.values()[choice];
	}

	public void DisplayCard(BlackJack.model.Card a_card) {
		System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
	}

	public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
		DisplayHand("Player", a_hand, a_score);
	}

	public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
		DisplayHand("Dealer", a_hand, a_score);
	}

	private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score) {
		System.out.println(a_name + " Has: ");
		for (BlackJack.model.Card c : a_hand) {
			DisplayCard(c);
		}
		System.out.println("Score: " + a_score);
		System.out.println("");
	}

	public void DisplayGameOver(boolean a_dealerIsWinner) {
		System.out.println("GameOver: ");
		if (a_dealerIsWinner) {
			System.out.println("Dealer Won!");
		} else {
			System.out.println("You Won!");
		}

	}

	public void DisplayDealingCard() {
		System.out.println("-----------------------------------" + "\nDealing the card...\n\n");
	}

}
