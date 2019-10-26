package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottoes {
    private final List<Lotto> lottoes;

    public Lottoes(final int amount) {
        lottoes = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottoes.add(new Lotto());
        }
    }

    public int getCount() {
        return lottoes.size();
    }

    public Lotto getLotto(final int index) {
        return lottoes.get(index);
    }
}
