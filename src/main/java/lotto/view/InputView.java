package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return readInput();
    }

    public String readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return readInput();
    }

    public String readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return readInput();
    }

    protected String readInput() {
        return Console.readLine();
    }
}
