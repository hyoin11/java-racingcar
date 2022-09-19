package LearningTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("size() 메소드를 이용해 크기를 구한다")
    void use_size_method_return_set_size(){
        //given

        //when
        int size = numbers.size();
        //then
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("contains 메소드를 이용해 요소 값이 존재하는지 확인한다.")
    void use_contain_method_check_value(int number){
        assertTrue(numbers.contains(number));
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true","2,true","3,true","4,false","5,false"})
    @DisplayName("numbers에서 포함된 숫자일 때는 true를 아니면 false를 반환한다.")
    void if_number_contain_value_return_true_or_return_false(String input, String expected){
        //given
        int inputValue = Integer.parseInt(input);
        boolean expectedBoolean = Boolean.parseBoolean(expected);
        //when

        //then
        assertEquals(numbers.contains(inputValue),expectedBoolean);
    }
}
