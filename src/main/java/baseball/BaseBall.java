package baseball;

public class BaseBall {
    private String answer = "234";
    private String userAnswer;

    private int strikeCount = 0;
    private int ballCount = 0;
    private Boolean isStart = true;

    private InputView input = new InputView();
    private ResultView result = new ResultView();

    public void init(){
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public Boolean isStrike(int index){
        if (userAnswer.charAt(index) == answer.charAt(index)) {
            strikeCount++;
            return true;
        }
        return false;
    }

    public Boolean isBall(int index){
        int result = answer.indexOf(userAnswer.charAt(index));
        if (result != index && result >= 0){
            ballCount++;
            return true;
        }
        return false;
    }

    public void compareBallAndStrike(int index){
        if (!isStrike(index)) {
            isBall(index);
        }
    }

    public void compareAnswer(){
        for (int i=0; i<userAnswer.length(); i++) {
            compareBallAndStrike(i);
        }
    }

    public void gameStart(){
        while(isStart) {
            init();
            userAnswer = input.input();
            compareAnswer();
            isStart = result.outputView(strikeCount, ballCount);
        }
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
