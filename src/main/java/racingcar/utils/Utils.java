package racingcar.utils;

import java.util.List;

public class Utils {
    private final static int MAXIMUM_CAR_NAME_LENGTH = 5;

    public static void validateStringSeparateWithComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("자동차의 이름은 쉼표(,) 기준으로 구분되어야 합니다.");
        }
    }

    public static void validateCarNameLength(List<String> carName) {
        for (String name : carName) {
            if (name.length() > MAXIMUM_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차의 이름은 5이하만 가능합니다.");
            }
        }
    }

    public static void validateStringIsDigit(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자를 입력해주세요.");
            }
        }
    }
}
