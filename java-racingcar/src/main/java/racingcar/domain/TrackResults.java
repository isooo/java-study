package racingcar.domain;

import java.util.*;

public class TrackResults {
    private final List<TrackResult> trackResultList;

    public TrackResults(final List<TrackResult> trackResultList) {
        this.trackResultList = Collections.unmodifiableList(trackResultList);
    }

    public RacingWinner getWinnerNames() {
        final TrackResult lastTrackResult = trackResultList.get(trackResultList.size() - 1);
        final List<String> winnerNames = lastTrackResult.getWinnerNames();
        return new RacingWinner(winnerNames);
    }

    public List<TrackResult> getTrackResultList() {
        return Collections.unmodifiableList(trackResultList);
    }
}
