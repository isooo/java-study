package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottoes {
    private final List<Lotto> lottoes;

    public Lottoes(final int amount) {
        lottoes = create(amount);
    }

    public Lottoes(final List<Lotto> lottoes) {
        this.lottoes = lottoes;
    }

    private List<Lotto> create(final int amount) {
        final List<Lotto> result = IntStream.rangeClosed(1, amount)
                .mapToObj(i -> new Lotto())
                .collect(Collectors.toList());
        return new ArrayList<>(result);
    }

    public int getCount() {
        return lottoes.size();
    }

    public Lotto getLotto(final int index) {
        return lottoes.get(index);
    }

    public MachedLottoes getMatchedLottoes(final Lotto winningLotto) {
        return new MachedLottoes(getMatchedLottos(winningLotto));
    }

    private List<MatchedLotto> getMatchedLottos(final Lotto winningLotto) {
        return lottoes.stream()
                    .map(lotto -> lotto.getMatchedLotto(winningLotto))
                    .collect(Collectors.toList());
    }
}
