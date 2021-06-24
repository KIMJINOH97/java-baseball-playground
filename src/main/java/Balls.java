import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Integer;
import java.util.stream.Collectors;

public class Balls {
    public final List<Ball> answer;

    public Balls(List<Integer> balls) {
        this.answer = mapBall(balls);
    }

    private List<Ball> mapBall(List<Integer> balls) {
        List<Ball> newBalls = new ArrayList<>();
        for (int i = 0; i < balls.size(); i++) {
            newBalls.add(new Ball(i+1, balls.get(i)));
        }
        return newBalls;
    }

    public BaseballResult play(List<Integer> balls){
        BaseballResult result = new BaseballResult();
        for (int i=0; i<balls.size(); i++) {
            Ball ball = new Ball(i+1, balls.get(i));
            BallStatus status = play(ball);
            result.report(status);
        }
        return result;
    }

    public BallStatus play(Ball ball) {
        BallStatus result = answer.stream().map(b -> ball.play(b))
                .filter(status -> status != BallStatus.NOTHING)
                .findFirst()
                .orElse(BallStatus.NOTHING);
        return result;
    }
}
