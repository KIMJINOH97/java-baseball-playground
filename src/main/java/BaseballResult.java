public class BaseballResult {
    int strike = 0;
    int ball = 0;


    public boolean isEnd(){
        if (strike == 3){
            return true;
        }
        return false;
    }

    public void report(BallStatus status) {
        if (status.isStrike()){
            strike++;
            return ;
        }
        if (status.isBall()){
            ball++;
            return ;
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
