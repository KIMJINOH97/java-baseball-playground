package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void addSet(){
        numbers = new HashSet<Integer>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set 사이즈 확인")
    @Test
    void size(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set안에 포함되어 있는 수 확인")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains(int number){
//        assertThat(numbers.contains(1)).isTrue();
//        assertThat(numbers.contains(2)).isTrue();
//        assertThat(numbers.contains(3)).isTrue();
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("CsvSource로 테스트")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void contains_csv(int input, Boolean expected){
//        Boolean actual = numbers.contains(Integer.parseInt(input));
//        System.out.println(numbers.contains(Integer.parseInt(input)));
        // Boolean class의 valueof가 있음
        assertEquals(numbers.contains(input), expected);
    }
}
