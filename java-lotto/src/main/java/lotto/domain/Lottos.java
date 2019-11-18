package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    Lottos(final List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public List<Lotto> get() {
        return new ArrayList<>(this.lottos);
    }

    public int size() {
        return this.lottos.size();
    }
}
