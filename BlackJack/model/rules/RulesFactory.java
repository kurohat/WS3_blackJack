package BlackJack.model.rules;

public class RulesFactory {

  public IHitStrategy GetHitRule() {
    return new SoftSeventeenHitStrategy();
  }

  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
  }
  
  public IWhoWinStrategy GetWinRule() {
	 return new PlayerWinsOnEqualStrategy(); // Give the power to player :P
  }
}