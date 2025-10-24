package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final Cars cars;
    private final Round round;

    public Race(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public RaceHistory start() {
        List<RoundResult> raceHistory = new ArrayList<>();
        while (round.isLeft()) {
            RoundResult result = cars.move(new RandomMovementStrategy(new ForwordMovementCondition()));
            round.finish();
            raceHistory.add(result);
        }
        return new RaceHistory(raceHistory);
    }
}
