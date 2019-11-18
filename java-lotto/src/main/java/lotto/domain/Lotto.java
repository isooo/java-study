package lotto.domain;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    private Lotto(final LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto create() {
        return new Lotto(LottoMachine.getNumbers());
    }

    public LottoNumbers getNumbers() {
        return this.lottoNumbers;
    }
}