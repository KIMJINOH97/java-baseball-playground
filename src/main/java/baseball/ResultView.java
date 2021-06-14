package baseball;


import java.util.Scanner;

public class ResultView {
    private int strike;
    private int ball;
    private Boolean restart = true;

    public ResultView(){}

    public ResultView(int strike, int ball){
        this.strike = strike;
        this.ball = ball;
    }

    public void printRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        int value = Integer.parseInt(scanner.nextLine());
        if (value == 2){
            restart = false;
        }
    }

    public void printBall(){
        if (ball == 0) return;
        System.out.print(String.valueOf(ball) + "볼 ");
    }

    public void printStrike(){
        if (strike == 0) return;
        System.out.print(String.valueOf(strike) + "스트라이크");
    }

    public void printBallAndStrike(){
        if (ball == 0 && strike == 0){
            System.out.println("낫싱");
            setRestart(false);
            return ;
        }
        printBall();
        printStrike();
        System.out.println();
    }

    public void printCorrect(){
        if (strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            printRestart();
        }
    }

    public Boolean outputView(int strike, int ball){
        this.strike = strike;
        this.ball = ball;
        printBallAndStrike();
        printCorrect();
        return restart;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public void setRestart(Boolean restart) {
        this.restart = restart;
    }
    public Boolean getRestart(){ return restart; }
}
