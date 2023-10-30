package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.core.Core;
import racingcar.model.Car;
import racingcar.utils.Utils;

import java.util.List;

public class Race {
    Core core = new Core();

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        Utils.validateStringSeparateWithComma(carName);
        List<String> carNames = core.stringToStringList(carName);
        Utils.validateStringLength(carNames);
        return carNames;
    }

    public void showResult(List<Car> cars, int count) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            core.forwardOrStop(cars);
            core.printResult(cars);
        }
    }

    public void printWinner(List<String> winner) {
        System.out.println("최종 우승자 : " + String.join(", ", winner));
        
    }
}