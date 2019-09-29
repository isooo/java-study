package racingcar.domain;

public class Car {
    private final int id;
    private final String name;
    private int position;

    private Car(final int id, final String name, final int position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    Car(final int id, final String name) {
        this(id, name, 0);
    }

    public int getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    void move(final boolean isMove) {
        if (isMove) {
            this.position++;
        }
    }

    Car copy() {
        return new Car(this.id, this.name, this.position);
    }
}
