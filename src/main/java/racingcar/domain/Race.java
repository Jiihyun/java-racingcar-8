package racingcar.domain;

import racingcar.dto.RaceHistory;
import racingcar.dto.RoundResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Race {

    private final Cars cars;
    private final Round round;

    public Race(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public RaceHistory start() {
        List<RoundResult> raceHistory = new ArrayList<>();
        Round currentRound = round;
        while (true) {
            Optional<Round> nextRound = playOneRound(raceHistory, currentRound);
            if (nextRound.isEmpty()) {
                break;
            }
            currentRound = nextRound.get();
        }
        return new RaceHistory(raceHistory);
    }

    private Optional<Round> playOneRound(List<RoundResult> raceHistory, Round currentRound) {
        RoundResult result = cars.move();
        raceHistory.add(result);
        return currentRound.decrease();
    }
}
