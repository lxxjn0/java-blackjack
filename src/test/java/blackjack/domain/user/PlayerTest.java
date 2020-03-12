package blackjack.domain.user;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import blackjack.domain.card.Deck;

class PlayerTest {
	@Test
	void Player_InputPlayerName_GenerateInstance() {
		assertThat(new Player("player")).isInstanceOf(Player.class);
	}

	@Test
	void canDraw_CurrentScoreLowerThanDrawableMaxScore_ReturnTrue() {
		assertThat(new Player("player").canDraw()).isTrue();
	}

	@ParameterizedTest
	@MethodSource("provideUndrawablePlayer")
	void canDraw_CurrentScoreMoreThanDrawableMaxScore_ReturnFalse(Player player) {
		assertThat(player.canDraw()).isFalse();
	}

	private static Stream<Arguments> provideUndrawablePlayer() {
		final int WORST_CASE_OF_DRAWABLE_COUNT = 12;

		Player player = new Player("player");
		Deck deck = new Deck();

		for (int i = 0; i < WORST_CASE_OF_DRAWABLE_COUNT; i++) {
			player.draw(deck);
		}
		return Stream.of(Arguments.of(player));
	}
}