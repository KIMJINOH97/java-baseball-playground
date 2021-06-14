package string_calculator;

import java.util.HashMap;
import java.util.Scanner;
import java.util.function.BiFunction;

public class Calculator {
    public HashMap<String, BiFunction<Integer, Integer, Integer>> operator = new HashMap<>();

    public Calculator(){
        operator.put("+", (num1, num2) -> plus(num1, num2));
        operator.put("-", (num1, num2) -> minus(num1, num2));
        operator.put("*", (num1, num2) -> multiply(num1, num2));
        operator.put("/", (num1, num2) -> divide(num1, num2));
    }

    public int plus(int num1, int num2){
        return num1 + num2;
    }

    public int minus(int num1, int num2){
        return num1 - num2;
    }

    public int multiply(int num1, int num2){
        return num1 * num2;
    }

    public int divide(int num1, int num2){
        return num1 / num2;
    }

    public Boolean isOperator(String op){
        return operator.get(op) == null ? false : true;
    }

    public int calculate(String expression, int num1, int num2){
        BiFunction<Integer, Integer, Integer> biFunction = operator.get(expression);
        if (biFunction == null){
            throw new IllegalArgumentException();
        }

        return biFunction.apply(num1, num2);
    }

    public void startGame(String[] values){
        int result = Integer.parseInt(values[0]);
        for (int i=1; i<values.length; i++){
            if (isOperator(values[i])){
                int num = Integer.parseInt(values[i + 1]);
                result = calculate(values[i], result, num);
            }
        }

        System.out.println(result);
    }

    public String[] InputView() {
        System.out.print("문자열 수식을 입력해주세요: ");
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        String[] values = value.split(" ");
        return values;
    }
}
