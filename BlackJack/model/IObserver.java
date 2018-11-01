package BlackJack.model;

public interface IObserver {
	public void setSubscriber(IObserver a_observer);
	public void notifySub();
	public void update(int a_delay);
}
