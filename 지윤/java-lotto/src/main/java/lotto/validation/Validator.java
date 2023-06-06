package lotto.validation;

import lotto.domain.Lotto;

import java.util.List;

public final class Validator {

    private Validator() {

    }

    // TODO: 여러 검증 로직을 짜보세요
    public static void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateInputPrice(long price) {
        if(price % Lotto.PRICE != 0) {
            throw new IllegalArgumentException("금액은 천원단위로 입력해주세요.");
        }
    }

}
