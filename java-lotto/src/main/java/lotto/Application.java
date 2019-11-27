package lotto;

import lotto.application.LottoService;
import lotto.ui.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController.run(new LottoService());
    }
}
