package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Race {

    private final Cars cars;
    private final Round round;
    private final MovementStrategy movementStrategy;

    public Race(Cars cars, Round round, MovementStrategy movementStrategy) {
        this.cars = cars;
        this.round = round;
        this.movementStrategy = movementStrategy;
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
        RoundResult result = cars.move(movementStrategy);
        raceHistory.add(result);
        return currentRound.decrease();
    }
}
