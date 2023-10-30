package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.core.Core;
import racingcar.model.Car;
import racingcar.utils.Utils;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void stringToStringList_테스트() {
        // given
        final Core T = new Core();
        String case1 = "pobi,woni,jun";
        String case2 = "kim,lee,park";
        String case3 = "james,tom,sam";

        // when
        final List<String> result1 =  T.stringToStringList(case1);
        final List<String> result2 =  T.stringToStringList(case2);
        final List<String> result3 =  T.stringToStringList(case3);

        // then
        assertThat(result1).isEqualTo(List.of("pobi", "woni", "jun"));
        assertThat(result2).isEqualTo(List.of("kim", "lee", "park"));
        assertThat(result3).isEqualTo(List.of("james", "tom", "sam"));
    }

    @Test
    void countForward() {
        // given
        Core T = new Core();
        final Car case1 = new Car("pobi", 4);
        final Car case2 = new Car("woni", 3);
        final Car case3 = new Car("jun", 2);

        // when
        final String result1 = T.countForward(case1);
        final String result2 = T.countForward(case2);
        final String result3 = T.countForward(case3);

        // then
        assertThat(result1).isEqualTo("----");
        assertThat(result2).isEqualTo("---");
        assertThat(result3).isEqualTo("--");
    }

    @Test
    void getWinner_테스트() {
        // given
        Core T = new Core();
        List<Car> case1 = List.of(new Car("pobi", 3), new Car("woni", 4), new Car("jun", 1));
        List<Car> case2 = List.of(new Car("kim", 2), new Car("lee", 4), new Car("park", 4));
        List<Car> case3 = List.of(new Car("james", 5), new Car("tom", 4), new Car("sam", 3));

        // when
        final List<String> result1 = T.getWinner(case1);
        final List<String> result2 = T.getWinner(case2);
        final List<String> result3 = T.getWinner(case3);

        // then
        assertThat(result1).isEqualTo(List.of("woni"));
        assertThat(result2).isEqualTo(List.of("lee", "park"));
        assertThat(result3).isEqualTo(List.of("james"));
    }

    @Test
    void validateStringSeparateWithComma_정상처리_테스트() {
        // given
        final String case1 = "pobi,woni,jun";
        final String case2 = "kim,lee,park";

        // when
        final Throwable thrown1 = catchThrowable(() -> {
            Utils.validateStringSeparateWithComma(case1);
        });
        final Throwable thrown2 = catchThrowable(() -> {
            Utils.validateStringSeparateWithComma(case2);
        });

        // then
        assertThat(thrown1).doesNotThrowAnyException();
        assertThat(thrown2).doesNotThrowAnyException();
    }

    @Test
    void validateStringSeparateWithComma_예외처리_테스트() {
        // given
        final String case1 = "pobi.woni.jun";
        final String case2 = "kim lee park";

        // when
        final Throwable thrown1 = catchThrowable(() -> {
            Utils.validateStringSeparateWithComma(case1);
        });
        final Throwable thrown2 = catchThrowable(() -> {
            Utils.validateStringSeparateWithComma(case2);
        });

        // then
        assertThat(thrown1).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 쉼표(,) 기준으로 구분되어야 합니다.");
        assertThat(thrown2).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 쉼표(,) 기준으로 구분되어야 합니다.");
    }

    @Test
    void validateCarNameLength_정상처리_테스트() {
        // given
        final List<String> case1 = List.of("pobi", "woni", "jun");
        final List<String> case2 = List.of("kim", "le e", "park");
        final List<String> case3 = List.of("james", "tom", "Mr.Jo");

        // when
        final Throwable thrown1 = catchThrowable(() -> {
            Utils.validateCarNameLength(case1);
        });
        final Throwable thrown2 = catchThrowable(() -> {
            Utils.validateCarNameLength(case2);
        });
        final Throwable thrown3 = catchThrowable(() -> {
            Utils.validateCarNameLength(case3);
        });

        // then
        assertThat(thrown1).doesNotThrowAnyException();
        assertThat(thrown2).doesNotThrowAnyException();
        assertThat(thrown3).doesNotThrowAnyException();
    }

    @Test
    void validateCarNameLength_예외처리_테스트() {
        // given
        final List<String> case1 = List.of("stephanie", "james", "robinson");
        final List<String> case2 = List.of("kim", "Jon Doe", "park");
        final List<String> case3 = List.of("BMW", "Mercedes", "Pagani Zonda");

        // when
        final Throwable thrown1 = catchThrowable(() -> {
            Utils.validateCarNameLength(case1);
        });
        final Throwable thrown2 = catchThrowable(() -> {
            Utils.validateCarNameLength(case2);
        });
        final Throwable thrown3 = catchThrowable(() -> {
            Utils.validateCarNameLength(case3);
        });

        // then
        assertThat(thrown1).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5이하만 가능합니다.");
        assertThat(thrown2).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5이하만 가능합니다.");
        assertThat(thrown3).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5이하만 가능합니다.");
    }

    @Test
    void validateStringIsDigit_정상처리_테스트() {
        // given
        final String case1 = "5";
        final String case2 = "10";

        // when
        final Throwable thrown1 = catchThrowable(() -> {
            Utils.validateStringIsDigit(case1);
        });
        final Throwable thrown2 = catchThrowable(() -> {
            Utils.validateStringIsDigit(case2);
        });

        // then
        assertThat(thrown1).doesNotThrowAnyException();
        assertThat(thrown2).doesNotThrowAnyException();
    }

    @Test
    void validateStringIsDigit_예외처리_테스트() {
        // given
        final String case1 = "!2";
        final String case2 = "Not a Number";

        // when
        final Throwable thrown1 = catchThrowable(() -> {
            Utils.validateStringIsDigit(case1);
        });
        final Throwable thrown2 = catchThrowable(() -> {
            Utils.validateStringIsDigit(case2);
        });

        // then
        assertThat(thrown1).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해주세요.");
        assertThat(thrown2).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해주세요.");
    }

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
