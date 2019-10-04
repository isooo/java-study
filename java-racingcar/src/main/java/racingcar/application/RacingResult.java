package racingcar.application;

import racingcar.domain.*;

// DTO
// Q : 서비스에서 컨트롤러로 넘겨줄 땐 어느 레이어에 있는게 맞는걸까
public class RacingResult {
    private final TrackResults trackResults;
    private final RacingWinner racingWinner;

    public RacingResult(final TrackResults trackResults, final RacingWinner racingWinner) {
        this.trackResults = trackResults;
        this.racingWinner = racingWinner;
    }

    public TrackResults getTrackResults() {
        return trackResults;
    }

    public RacingWinner getRacingWinner() {
        return racingWinner;
    }
}
