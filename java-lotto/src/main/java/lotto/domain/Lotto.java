package lotto.domain;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    Lotto(final LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto create() {
        return new Lotto(LottoMachine.getNumbers());
    }

    public LottoNumbers getNumbers() {
        return this.lottoNumbers;
    }

    public LottoPrize calculateWinningStatistics(final LottoNumbers winningLottoNumbers) {
        final long count = this.lottoNumbers.calculateCountOfWinningNumbers(winningLottoNumbers);
        return LottoPrize.of(count);
    }
}
