import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    Ball ball;

    @BeforeEach
    void init(){
        this.ball = new Ball(1, 1);
    }

    @Test
    void strike(){
        assertThat(ball.play(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball(){
        assertThat(ball.play(new Ball(2, 1))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing(){
        assertThat(ball.play(new Ball(3, 2))).isEqualTo(BallStatus.NOTHING);
    }
}
