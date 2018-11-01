package BlackJack.view;

public class SimpleView implements IView {

	public void DisplayWelcomeMessage() {
		for (int i = 0; i < 50; i++) {
			System.out.print("\n");
		}
		;
		System.out.println("LET PLAY BLACK JACK, GO HARD OR GO HOME YOOOO!!");
		System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
	}

	public int GetInput() {
		try {
			int c = System.in.read();
			while (c == '\r' || c == '\n') {
				c = System.in.read();
			}
			return c;
		} catch (java.io.IOException e) {
			System.out.println("" + e);
			return 0;
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
		if (a_dealerIsWinner) {
			System.out.println("Dealer Won!");
		} else {
			System.out.println("You Won!");
		}

	}
	
	public void DisplayDealingCard() {
		System.out.println("-----------------------------------"
				+ "\nDealing the card...\n\n");
	}

	@Override
	public boolean Play(int input) {
		return input == 'p';
	}

	@Override
	public boolean Hit(int input) {
		return input == 'h';

	}

	@Override
	public boolean Stand(int input) {
		return input == 's';
	}

	@Override
	public boolean Quit(int input) {
		return input == 'q';
	}
}
