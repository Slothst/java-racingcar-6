package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.core.Core;
import racingcar.model.Car;
import racingcar.utils.Utils;

import java.util.List;

public class Race {
    Core T = new Core();

    public void run() {
        List<String> carNames = getCarNames();
        List<Car> cars = T.makeCarListByCarNames(carNames);
        int count = T.getCount();
        showResult(cars, count);
        printWinner(T.getWinner(cars));
    }

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        Utils.validateStringSeparateWithComma(carName);
        List<String> carNameList = T.stringToStringList(carName);
        Utils.validateCarNameLength(carNameList);
        return carNameList;
    }

    public void showResult(List<Car> cars, int count) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            T.forwardOrStop(cars);
            T.printResult(cars);
        }
    }

    public void printWinner(List<String> winner) {
        System.out.print("최종 우승자 : " + String.join(", ", winner));
    }
}
