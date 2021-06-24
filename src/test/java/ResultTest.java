import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    void strike3(){
        Balls ans = new Balls(Arrays.asList(1, 2, 3));
        BaseballResult result = ans.play(Arrays.asList(1,2,3));
        assertThat(result.isEnd()).isTrue();
    }

    @Test
    void Strike1Ball1(){
        Balls ans = new Balls(Arrays.asList(1, 2, 3));
        BaseballResult result = ans.play(Arrays.asList(1,3,4));
        assertThat(result.isEnd()).isFalse();
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void Ball3(){
        Balls ans = new Balls(Arrays.asList(1, 2, 3));
        BaseballResult result = ans.play(Arrays.asList(3,1,2));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(3);
    }
}