package racingcar.domain;

public class Car {
    private final Long id;
    private int position;

    public Car(final Long id) {
        this.id = id;
        this.position = 0;
    }

    private Car(final Long id, final int position) {
        this.id = id;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public void move(final boolean isMove) {
        if (isMove) {
            this.position++;
        }
    }
}
