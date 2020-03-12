package blackjack.view;

import java.util.List;

import blackjack.domain.card.Card;
import blackjack.domain.user.Dealer;
import blackjack.domain.user.User;
import blackjack.util.StringUtil;

public class OutputView {
	private static final String NEWLINE = System.getProperty("line.separator");
	private static final String INITIAL_DRAW_FORMAT = "%s와 %s에게 %d장의 나누었습니다.";

	public static void printUsersInitialDraw(int initialDrawNumber, List<User> users) {
		System.out.println(
			String.format(NEWLINE + INITIAL_DRAW_FORMAT,
				Dealer.NAME,
				StringUtil.joinPlayerNames(users),
				initialDrawNumber));
		users.forEach(user -> printUserHand(user, user.getInitialHand()));
	}

	public static void printUserHand(User user, List<Card> hand) {
		System.out.println(user.getName() + ": " + StringUtil.joinCards(hand));
	}
}
