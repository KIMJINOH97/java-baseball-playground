import baseball.BaseBall;
import string_calculator.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Calculator calculator = new Calculator();
//        String[] input = calculator.InputView();
//        calculator.startGame(input);
        BaseBall baseBall = new BaseBall();
        baseBall.gameStart();
    }
}
