package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public class DealerWinsOnEqualStrategy implements IWhoWinStrategy {

	private final int g_maxScore = 21;

    /*
     * In this case, Dealer have more "power"
     * Dealer’ score >= player’s score -> Dealer win the game
     * Player get more score than 21 (bust) -> Dealer win the game
     * Dealer busts -> player wins the game
     */
    @Override
    public boolean IsDealerTheWinner(Dealer a_dealer, Player a_player) {
        if (a_player.CalcScore() > g_maxScore) {
            return true;
        } else if (a_dealer.CalcScore() > g_maxScore) {
            return false;
        } 
        return a_dealer.CalcScore() >= a_player.CalcScore();
    }


}
