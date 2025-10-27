package racingcar.dto;

import java.util.List;

public record RoundResult(List<CarResult> roundResult) {

    public RoundResult {
        roundResult = List.copyOf(roundResult);
    }
}
