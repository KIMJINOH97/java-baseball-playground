package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseBallTest {
    public BaseBall baseBall = new BaseBall();

    @BeforeEach
    void init(){
        baseBall.setAnswer("152");
        baseBall.setUserAnswer("123");
    }

    @DisplayName("스트라이크 확인")
    @ParameterizedTest
    @CsvSource({"0,true", "1,false", "2,false"})
    void checkStrike(int index, Boolean isOk){
        assertEquals(baseBall.isStrike(index), isOk);
    }

    @DisplayName("볼 확인")
    @ParameterizedTest
    @CsvSource({"0,false", "1,true", "2,false"})
    void checkBall(int index, Boolean isOk){
        assertEquals(baseBall.isBall(index), isOk);
    }

    @DisplayName("전체 확인")
    @Test
    void checkAll(){
         baseBall.compareAnswer();
         assertThat(baseBall.getStrikeCount()).isEqualTo(1);
         assertThat(baseBall.getBallCount()).isEqualTo(1);
    }

    @DisplayName("한 index에서 스트라이크 볼 판별")
    @Test
    void compare(){
        baseBall.compareBallAndStrike(0);
        assertThat(baseBall.getStrikeCount()).isEqualTo(1);
        assertThat(baseBall.getBallCount()).isEqualTo(0);
    }

}