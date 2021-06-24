public class Ball {
    int location;
    int ballNo;

    public Ball(int location, int ballNo) {
        this.location = location;
        this.ballNo = ballNo;
    }

    public BallStatus play(Ball ball) {
        if (isStrike(ball)){
            return BallStatus.STRIKE;
        }

        if (isBall(ball)){
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    private boolean isBall(Ball ball) {
        return ball.ballNo == ballNo;
    }

    private boolean isStrike(Ball ball) {
        return ball.location == location && ball.ballNo == ballNo;
    }
}
