package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.CarName;
import racing.domain.CarPosition;
import racing.domain.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @DisplayName("생성한 자동차들의 크기를 가지고올 수 있다.")
    @Test
    void carsSizeTest() {
        Car car1 = new Car(new CarName("t1"), new CarPosition(0));
        Car car2 = new Car(new CarName("t2"), new CarPosition(0));
        Car car3 = new Car(new CarName("t3"), new CarPosition(0));
        Cars cars = new Cars(List.of(car1, car2, car3));

        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @DisplayName("생성한 자동차들에서 인덱스를 넘기면 해당 자동차를 가져올 수 있다.")
    @Test
    void carGetTest() {
        Car car1 = new Car(new CarName("t1"), new CarPosition(0));
        Car car2 = new Car(new CarName("t2"), new CarPosition(0));
        Car car3 = new Car(new CarName("t3"), new CarPosition(0));
        Cars cars = new Cars(List.of(car1, car2, car3));

        assertThat(cars.getCar(1)).isEqualTo(car2);
    }

    @DisplayName("가장 멀리간 자동차를 가져올 수 있다.")
    @Test
    void findWinner() {
        Car car1 = new Car(new CarName("t1"), new CarPosition(2));
        Car car2 = new Car(new CarName("t2"), new CarPosition(5));
        Car car3 = new Car(new CarName("t3"), new CarPosition(1));
        Cars cars = new Cars(List.of(car1, car2, car3));

        assertThat(cars.findWinners().getWinners().size()).isEqualTo(1);
    }

    @DisplayName("가장 멀리간 자동차들을 가져올 수 있다.")
    @Test
    void findWinners() {
        Car car1 = new Car(new CarName("t1"), new CarPosition(2));
        Car car2 = new Car(new CarName("t2"), new CarPosition(5));
        Car car3 = new Car(new CarName("t3"), new CarPosition(5));
        Cars cars = new Cars(List.of(car1, car2, car3));

        assertThat(cars.findWinners().getWinners().size()).isEqualTo(2);
    }
}