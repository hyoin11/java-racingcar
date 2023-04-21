package racingCarGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingCarGame.view.InputView;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarGameTest {
    @ParameterizedTest
    @CsvSource(
            value = {
                    "NotM, NotM, M, 1",
                    "NotM, M, M, 2",
                    "M, M, M, 3"
            },
            delimiter = ',')
    @DisplayName("findWinner()는 가장 높은 점수를 가진 우승자 여러명을 찾아준다.")
    void getMultipleWinners(
            String strategy1,
            String strategy2,
            String strategy3,
            String winnerCount
    ) {
        InputView input = new InputView("pobi,yong,kei", 3);
        RacingCarGame racingCarGame = new RacingCarGame(input);

        racingCarGame.getCars().get(0).move(getStrategy(strategy1));
        racingCarGame.getCars().get(1).move(getStrategy(strategy2));
        racingCarGame.getCars().get(2).move(getStrategy(strategy3));

        assertThat(racingCarGame.findWinner().size()).isEqualTo(Integer.parseInt(winnerCount));
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "NotM, M, NotM, yong",
            },
            delimiter = ',')
    @DisplayName("findWinner()는 가장 높은 점수를 가진 우승자를 찾아준다.")
    void getOnlyWinner(
            String strategy1,
            String strategy2,
            String strategy3,
            String winner
    ) {
        InputView input = new InputView("pobi,yong,kei", 3);
        RacingCarGame racingCarGame = new RacingCarGame(input);

        racingCarGame.getCars().get(0).move(getStrategy(strategy1));
        racingCarGame.getCars().get(1).move(getStrategy(strategy2));
        racingCarGame.getCars().get(2).move(getStrategy(strategy3));

        assertThat(racingCarGame.findWinner().size()).isEqualTo(1);
        assertThat(racingCarGame.findWinner().get(0)).isEqualTo(winner);
    }

    private MoveStrategy getStrategy(String strategy) {
        if (strategy.equals("NotM")) {
            return new NotMoveStrategy();
        }
        return new AlwaysMoveStrategy();
    }
}
