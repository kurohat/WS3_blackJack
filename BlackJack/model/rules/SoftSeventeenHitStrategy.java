package BlackJack.model.rules;

import BlackJack.model.Player;
import BlackJack.model.Card;

public class SoftSeventeenHitStrategy implements IHitStrategy {

	private final int g_hitLimit = 17;

	public boolean DoHit(Player a_dealer) {
		if (a_dealer.CalcScore() == g_hitLimit) {
			int cardScores[] = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11 };
			int score = 0;
			for (Card c : a_dealer.GetHand()) {
				if (c.GetValue() != Card.Value.Ace) {
					score += cardScores[c.GetValue().ordinal()];
				}
			}
			return score <= 6;
		}
		return a_dealer.CalcScore() < g_hitLimit;
	}

}
