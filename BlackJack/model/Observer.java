package BlackJack.model;

public abstract class Observer {
	//to send an event to the user interface that a player has got a new card in his hand.
	public abstract void update();
}
