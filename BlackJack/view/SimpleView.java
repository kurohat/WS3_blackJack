package BlackJack.view;

import java.util.EnumSet;

public class SimpleView implements IView {

	public void DisplayWelcomeMessage() {
		for (int i = 0; i < 50; i++) {
			System.out.print("\n");
		}
		;
		System.out.println("LET PLAY BLACKJACK, GO HARD OR GO HOME YOOOO!!");
	}

	public void GetInput() {
		for (Action choices : EnumSet.allOf(Action.class)) {
			System.out.print(choices.ordinal() + ": " + choices + " | ");
		}

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
		System.out.println((a_dealerIsWinner ? "Dealer won!" : "You won!"));
	}

	public void DisplayDealingCard() {
		System.out.println("-----------------------------------" + "\nDealing the card...\n\n");
	}

}
