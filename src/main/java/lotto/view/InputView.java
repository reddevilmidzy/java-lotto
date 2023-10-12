package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Message;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public int getPurchaseAmount() {
        String input = getUserInput(Message.INPUT_PURCHASE_NUMBER);
        System.out.println();
        return validDate(input);
    }

    public int getBonusNumber() {
        String input = getUserInput(Message.INPUT_BONUS_NUMBER);
        System.out.println();
        return validDate(input);
    }

    public List<Integer> getWinningNumbers() {
        String input = getUserInput(Message.INPUT_WINNING_NUMBER);
        System.out.println();
        return validSplitDate(input);
    }

    private String getUserInput(String output) {
        System.out.println(output);
        return Console.readLine();
    }

    private int validDate(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.NOT_VALID_TYPE);
        }
    }

    private List<Integer> validSplitDate(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.NOT_VALID_TYPE);
        }
    }
}
