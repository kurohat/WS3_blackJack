package BlackJack.view;

public interface IView {
	void DisplayWelcomeMessage();

	int GetInput();

	void DisplayCard(BlackJack.model.Card a_card);

	void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);

	void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);

	void DisplayGameOver(boolean a_dealerIsWinner);
	
	void DisplayDealingCard();
	
	boolean Play(int input);

	boolean Hit(int input);

	boolean Stand(int input);

	boolean Quit(int input);
	
}