import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    Balls answer;

    @BeforeEach
    void init(){
        this.answer = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void strike(){
        assertThat(answer.play(new Ball(1,1))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball(){
        assertThat(answer.play(new Ball(1, 2))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing(){
        assertThat(answer.play(new Ball(2,4))).isEqualTo(BallStatus.NOTHING);
    }

}
