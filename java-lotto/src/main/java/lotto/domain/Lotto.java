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

    public boolean contains(final LottoNumber bonusLottoNumber) {
        return this.lottoNumbers.contains(bonusLottoNumber);
    }

    public LottoPrize calculateWinningStatistics(final LottoNumbers winningLottoNumbers, final boolean matchBonus) {
        final long count = this.lottoNumbers.calculateCountOfWinningNumbers(winningLottoNumbers);
        return LottoPrize.of(count, matchBonus);
    }
}
