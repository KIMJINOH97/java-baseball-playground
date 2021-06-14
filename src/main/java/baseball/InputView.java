package baseball;

import java.util.Scanner;

public class InputView {
    public String input(){
        System.out.print("숫자를 입력해주세요 : ");
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        return str1;
    }
}
