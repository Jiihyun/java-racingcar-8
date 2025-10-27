package racingcar.dto;

import java.util.List;

public record Winners(List<String> winners) {

    public Winners {
        winners = List.copyOf(winners);
    }
}
