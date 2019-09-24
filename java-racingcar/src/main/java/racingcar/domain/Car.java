package racingcar.domain;

public class Car {
    private final int id;
    private final String name;
    private int position;

    Car(final int id, final String name) {
        this.id = id;
        this.name = name;
        this.position = 0;
    }

    private Car(final int id, final String name, final int position) {
        this.id = id;
        this.name = name;
        this.position = position;
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
        return new Car(this.getId(), this.getName(), this.getPosition());
    }
}
