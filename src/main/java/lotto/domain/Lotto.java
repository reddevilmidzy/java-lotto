package lotto.domain;

import lotto.constant.Message;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBERS_LENGTH = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumber() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isValidSize(numbers)) {
            throw new IllegalArgumentException(Message.NOT_VALID_LENGTH);
        }
        if (!isValidRange(numbers)) {
            throw new IllegalArgumentException(Message.NOT_VALID_RANGE_NUMBER);
        }
        if (!isValidUnique(numbers)) {
            throw new IllegalArgumentException(Message.NOT_UNIQUE);
        }
    }

    private boolean isValidSize(List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBERS_LENGTH;
    }

    private boolean isValidRange(List<Integer> numbers) {
        return numbers.stream()
                .noneMatch(number -> number < START_LOTTO_NUMBER || END_LOTTO_NUMBER < number);
    }

    private boolean isValidUnique(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() == LOTTO_NUMBERS_LENGTH;
    }
}
