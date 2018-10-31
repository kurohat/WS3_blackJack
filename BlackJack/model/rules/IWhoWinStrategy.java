package BlackJack.model.rules;

import BlackJack.model.*;

public interface IWhoWinStrategy {

	boolean IsDealerTheWinner(Dealer a_dealer, Player a_player);
}
