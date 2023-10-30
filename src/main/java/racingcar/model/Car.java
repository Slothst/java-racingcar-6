package racingcar.model;

public class Car {
    private final String name;
    private int forward;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int forward) {
        this.name = name;
        this.forward = forward;
    }

    public String getName() {
        return name;
    }

    public int getForward() {
        return forward;
    }

    public void setForward(int forward) {
        this.forward = forward;
    }
}
