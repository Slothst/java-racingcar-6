package racingcar.core;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.Utils;
import racingcar.model.Car;

import java.util.*;

public class Core {
    private final static int MINIMUM_RANDOM_NUMBER = 1;
    private final static int MAXIMUM_RANDOM_NUMBER = 9;
    private final static int MINIMUM_FORWARD_NUMBER = 3;

    public List<String> stringToStringList(String input) {
        return Arrays.stream(input.split(",")).toList();
    }

    public List<Car> makeCarListByCarNames(List<String> carName) {
        List<Car> cars = new ArrayList<>();
        for (String name : carName) {
            Car car = new Car(name);
            cars.add(car);
        }
        return cars;
    }

    public int getCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String userInput = Console.readLine();
        Utils.validateStringIsDigit(userInput);
        return Integer.parseInt(userInput);
    }

    public void forwardOrStop(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER);
            if (randomNumber > MINIMUM_FORWARD_NUMBER) {
                car.setForward(car.getForward() + 1);
            }
        }
    }

    public String countForward(Car car) {
        return "-".repeat(Math.max(0, car.getForward()));
    }

    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : " + countForward(car) + "\n");
        }
        System.out.println();
    }

    public List<String> getWinner(List<Car> cars) {
        List<String> winner = new ArrayList<>();
        int max_val = 0;
        for (Car car : cars) {
            if (max_val < car.getForward()) {
                max_val = car.getForward();
                winner = new ArrayList<>();
                winner.add(car.getName());
                continue;
            }
            if (max_val == car.getForward()) {
                winner.add(car.getName());
            }
        }
        return winner;
    }
}
