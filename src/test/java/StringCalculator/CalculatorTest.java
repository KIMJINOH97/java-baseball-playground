package StringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import string_calculator.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @DisplayName("더하기 테스트")
    @Test
    void plus() {
        //given
        int num1 = 1;
        int num2 = 2;

        assertThat(calculator.plus(num1, num2)).isEqualTo(3);
    }

    @DisplayName("빼기 테스트")
    @Test
    void minus() {
        //given
        int num1 = 10;
        int num2 = 3;

        assertThat(calculator.minus(num1, num2)).isEqualTo(7);
    }

    @DisplayName("곱하기 테스트")
    @Test
    void multiply() {
        //given
        int num1 = 2;
        int num2 = 3;

        assertThat(calculator.multiply(num1, num2)).isEqualTo(6);

    }

    @DisplayName("나누기 테스트")
    @Test
    void divide() {
        //given
        int num1 = 6;
        int num2 = 2;

        assertThat(calculator.divide(num1, num2)).isEqualTo(3);
    }

    @DisplayName("연산 테스트")
    @Test
    void calculate() {
        //given
        String op = "+";
        int num1 = 2;
        int num2 = 3;

        assertThat(calculator.calculate(op, num1, num2)).isEqualTo(5);
    }

    @DisplayName("연산자가 맞는지 테스트")
    @ParameterizedTest
    @CsvSource({"+,true", "1,false"})
    void isOperate(String op, Boolean isOp){
        //given
        assertEquals(calculator.isOperator(op), isOp);
    }

    @DisplayName("계산 테스트")
    @Test
    void calculate_str(){
        //given
        int num1 = 10;
        int num2 = 20;
        String op = "*";
        String op2 = "//";

        assertThat(calculator.calculate(op, num1, num2)).isEqualTo(200);
        assertThatThrownBy(() -> calculator.calculate(op2, num1, num2)).isInstanceOf(IllegalArgumentException.class);
    }
}