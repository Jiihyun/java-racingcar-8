package racingcar.domain;

import java.util.List;

public record RaceHistory(
        List<RoundResult> history
) {
}
